/**
 * Created by huihuazhang on 2016/4/27.
 * 基于HTML5 文件上传的核心脚本
 * http://www.w3.org/TR/html-markup/input.file.html
 */
(function($){
    function readAsDataURL(img, file, maxW, maxH){
        // Using FileReader to display the image content
        var reader = new FileReader();
        reader.onload = (function(aImg) {
            return function(e) {
                aImg.src = e.target.result;
                var width = aImg.naturalWidth,
                    height = aImg.naturalHeight;
                aImg.setAttribute("data-width", width);
                aImg.setAttribute("data-height", height);
                if (maxW && maxH) {
                    if (width>maxW){
                        aImg.setAttribute("width", maxW);
                    }
                    if( height > maxH) {
                        aImg.setAttribute("height", maxH);
                    }
                }

            };
        })(img);

        reader.readAsDataURL(file);
    }

    function previewUploadImg($uploadWrap, files, maxW, maxH) {
        var $previewElem = $("<div class=\"thumbnail\"></div>").appendTo($uploadWrap);
        var file = files[0];
        if (!file) {return false;}
        if (!file.type.match(/image.*/)) {
            throw "File Type must be an image";
        }
        var img = document.createElement("img");
        img.file = file;
        $previewElem.empty().append(img);

        if ($previewElem.find(".del-icon").length == 0) {
            $("<a class=\"del-icon\"></a>").appendTo($previewElem).click(function(event){
                $previewElem.remove();
                $uploadWrap.find("input[type=file]").val("");
            });
        }
        if ($previewElem.find(".edit-icon").length == 0 && $uploadWrap.find("input[name=base64File]").length) {
            $("<a class=\"edit-icon\"></a>").appendTo($previewElem).click(function(event){
                editImg($uploadWrap,file,file.name,function(dataURL,fileName){
                    if(dataURL){
                        img.src=dataURL;
                        $uploadWrap.find("input[name=base64File]").val(dataURL.substring(dataURL.indexOf("base64,")+7));
                        $uploadWrap.find("input[name=originalFilename]").val(fileName);
                        $uploadWrap.find("input[type=file]").val("");
                    }
                });
            });
        }
        readAsDataURL(img, file, maxW, maxH);
    }

    function editImg($uploadWrap,img,fileName,callback){
        if(0 == $uploadWrap.parent().find(".image-editor").length ) {
            $uploadWrap.after("<div class=\"image-editor\"></div>");
        }
        var $this = $uploadWrap.parent().find(".image-editor");
        if($this.attr("data-id")){
            JUI.instances[$this.attr("data-id")].terminate();
            delete JUI.instances[$this.attr("data-id")];
        }
        var index = window.imageEditor.index++;
        var dataId = "imageEditor_"+index;
        var widthInput=$uploadWrap.find("input[name=width]");
        var heightInput=$uploadWrap.find("input[name=height]");
        function initSize(imageEditor,width,height){
            if(width && height){
                imageEditor.render({
                    Crop:{
                        autoResize: true,
                        presetsItems:[
                            {
                                titleKey: 'custom',
                                descriptionKey: width+'*'+height,
                                width: width,
                                height: height,
                                disableManualResize:true
                            }
                        ]
                    }
                });
            }
        }
        widthInput.change(function(){
            if(JUI.instances[$this.data("id")]){
                initSize(JUI.instances[$this.data("id")],parseInt(widthInput.val()),parseInt(heightInput.val()));
            }
        });
        heightInput.change(function(){
            if(JUI.instances[$this.data("id")]){
                initSize(JUI.instances[$this.data("id")],parseInt(widthInput.val()),parseInt(heightInput.val()));
            }
        });
        function init(dataId,img){
            filerobotImageEditorConfig.source=img;
            var imageEditor = new FilerobotImageEditor($this[0], filerobotImageEditorConfig);
            JUI.instances[dataId] = imageEditor;
            imageEditor.render({
                onSave:function(imageData, imageDesignState){
                    if ($.isFunction(callback) ) {
                        callback(imageData.imageBase64,imageData.fullName);
                    }
                },
                onClose: function(closingReason, haveNotSavedChanges){
                  imageEditor.terminate();
                  delete JUI.instances[dataId];
                }
            });
            initSize(JUI.instances[this.data("id")],parseInt(widthInput.val()),parseInt(heightInput.val()));
        }
        if(window.imageEditor.initd){
            init(dataId,img);
        } else {
            loadScripts(window.imageEditor.resources,function(){
                window.imageEditor.initd=true;
                init(dataId,img);
            });
        }
        $this.attr("data-id",dataId);
    }

    // multiple
    function previewUploadImg2($uploadWrap, files, maxW, maxH) {
        var rel = $uploadWrap.attr("rel");
        var $previewElem = $(rel);
        $previewElem.empty();
        for (var index=0; index<files.length; index++) {
            var file = files[index];
            var $thumb = $("<li class=\"thumbnail\"></li>");
            var img = document.createElement("img");
            img.file = file;
            $thumb.append(img);
            $previewElem.append($thumb);
            readAsDataURL(img, file, maxW, maxH);
        }
    }

    $.fn.extend({
        /**
         * 图片编辑
         * @param options
         */
        editImg: function(options){
            $uploadWrap = $(this);
            var $previewElem = $uploadWrap.find(".thumbnail");
            if(0 == $previewElem.length){
                $previewElem = $("<div class=\"thumbnail\"></div>").appendTo($uploadWrap);
            }
            var img = document.createElement("img");
            img.src = options.imgUrl;
            $previewElem.empty().append(img);

            editImg($(this),options.imgUrl,options.imgName,function(dataURL,fileName){
                if(dataURL){
                    img.src=dataURL;
                    $uploadWrap.find("input[name=base64File]").val(dataURL.substring(dataURL.indexOf("base64,")+7));
                    $uploadWrap.find("input[name=originalFilename]").val(fileName);
                    $uploadWrap.find("input[type=file]").val("");
                    if ($previewElem.find(".del-icon").length == 0) {
                        $("<a class=\"del-icon\"></a>").appendTo($previewElem).click(function(event){
                            $previewElem.remove();
                            $uploadWrap.find("input[name=base64File]").val("");
                            $uploadWrap.find("input[name=originalFilename]").val("");
                        });
                    }
                }
            });
        }
    });

    $.fn.extend({
        /**
         * 选择上传图片缩略图列表预览
         * @param options
         */
        previewUploadImg: function(options){
            var op = $.extend({maxW:80, maxH:80}, options);
            return this.each(function(){
                var $uploadWrap = $(this);

                var $inputFiles = $uploadWrap.find("input[type=file]");
                $inputFiles.each(function(index){
                    var $inputFile = $(this).css({left:(op.maxW*index)+"px"});
                    $inputFile.on("change", function () {
                        var files = this.files;

                        if (this.multiple) {
                            previewUploadImg2($uploadWrap, files, op.maxW, op.maxH);
                        } else {
                            previewUploadImg($uploadWrap, files, op.maxW, op.maxH);
                        }
                    });
                });

                var $delIcon = $uploadWrap.find(".del-icon");
                if ($delIcon) { // 删除服务器上的图片
                    $delIcon.click(function(event){
                        $.ajax({
                            type: "GET",
                            url:$delIcon.attr("href"),
                            dataType:"json",
                            cache: false,
                            success: function(json){
                                JUI.ajaxDone(json);

                                if (json[JUI.keys.statusCode] == JUI.statusCode.ok){
                                    $uploadWrap.find("div.thumbnail").remove();
                                    $uploadWrap.find("input[type=file]").val("");
                                }
                            },
                            error: JUI.ajaxError
                        });

                        return false;
                    });
                }

            });
        }
    });


    JUI.regPlugins.push(function($p){
        $("div.upload-wrap", $p).previewUploadImg({maxW:300,maxH:200});
    });

})(jQuery);