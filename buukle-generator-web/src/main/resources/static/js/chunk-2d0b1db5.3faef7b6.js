(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0b1db5"],{2243:function(e,t,a){"use strict";a.r(t);var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-modal",{attrs:{destroyOnClose:!0,width:1080,visible:e.visible,title:e.getTitle(e.initvalue)},model:{value:e.visible,callback:function(t){e.visible=t},expression:"visible"}},[a("div",{staticClass:"main"},[a("a-form-model",{ref:"form",attrs:{layout:e.formLayout,model:e.form,rules:e.rules}},[a("a-form-model-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{label:"id",prop:"id","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-input",{model:{value:e.form.id,callback:function(t){e.$set(e.form,"id",t)},expression:"form.id"}})],1),a("span",{staticStyle:{"font-size":"15px","font-weight":"1000",color:"#827f7f"}},[e._v(" 基础配置 ")]),a("div",{staticStyle:{border:"2px #dccece solid","border-style":"dashed","padding-top":"20px","padding-right":"20px","margin-top":"15px","margin-bottom":"15px"}},[a("a-form-model-item",{attrs:{label:"配置名称",prop:"name","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"请输入配置名称"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1)],1),a("span",{staticStyle:{"font-size":"15px","font-weight":"1000",color:"#827f7f"}},[e._v(" 连接配置 ")]),a("div",{staticStyle:{border:"2px #dccece solid","border-style":"dashed","padding-top":"20px","padding-right":"20px","margin-top":"15px","margin-bottom":"15px"}},[a("a-form-model-item",{attrs:{label:"选择连接",prop:"datasourcesName","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-select",{attrs:{placeholder:"请选择连接"},on:{change:e.datasourcesChange},model:{value:e.form.datasourcesName,callback:function(t){e.$set(e.form,"datasourcesName",t)},expression:"form.datasourcesName"}},e._l(e.datasourcesList,(function(t){return a("a-select-option",{key:t.id,attrs:{value:t.name?t.name:t.id+1,title:t.name}},[e._v(" "+e._s(t.name?t.name:t.id+1)+" ")])})),1)],1),a("a-form-model-item",{attrs:{label:"选择表名",prop:"tables","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},e._l(e.form.tableList,(function(t){return a("label",{key:t.name,attrs:{value:t.name}},[a("div",{staticStyle:{float:"left","margin-right":"25px"}},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.form.tables,expression:"form.tables"}],attrs:{type:"checkbox"},domProps:{value:t.name,checked:Array.isArray(e.form.tables)?e._i(e.form.tables,t.name)>-1:e.form.tables},on:{change:function(a){var o=e.form.tables,r=a.target,l=!!r.checked;if(Array.isArray(o)){var s=t.name,i=e._i(o,s);r.checked?i<0&&e.$set(e.form,"tables",o.concat([s])):i>-1&&e.$set(e.form,"tables",o.slice(0,i).concat(o.slice(i+1)))}else e.$set(e.form,"tables",l)}}}),e._v(" "+e._s(t.name)+" ")])])})),0)],1),a("span",{staticStyle:{"font-size":"15px","font-weight":"1000",color:"#827f7f"}},[e._v(" 生成配置 ")]),a("div",{staticStyle:{border:"2px #dccece solid","border-style":"dashed","padding-top":"20px","padding-right":"20px","margin-top":"15px","margin-bottom":"15px"}},[a("a-form-model-item",{attrs:{label:"包前缀名",prop:"basePackage","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"包前缀名"},model:{value:e.form.basePackage,callback:function(t){e.$set(e.form,"basePackage",t)},expression:"form.basePackage"}})],1),a("a-form-model-item",{attrs:{label:"模块前缀",prop:"bak01","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-input",{attrs:{placeholder:"模块前缀"},model:{value:e.form.bak01,callback:function(t){e.$set(e.form,"bak01",t)},expression:"form.bak01"}}),a("span",{staticStyle:{color:"red","font-size":"12px","line-height":"0px !important"}},[e._v(" * 注 : 如项目为子模块项目,则可填写此项,生成的文件会按照 controller ,dao 等MVC分层,生成到不同的分层文件夹下;如不填写,则生成到统一文件夹下.")])],1),a("a-form-model-item",{attrs:{label:"选择模板",prop:"templateIds","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},e._l(e.form.templatesList,(function(t){return a("label",{key:t.name,attrs:{value:t.name}},[a("div",{staticStyle:{float:"left","margin-right":"25px"}},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.form.templateIds,expression:"form.templateIds"}],attrs:{type:"checkbox"},domProps:{value:t.id,checked:Array.isArray(e.form.templateIds)?e._i(e.form.templateIds,t.id)>-1:e.form.templateIds},on:{change:function(a){var o=e.form.templateIds,r=a.target,l=!!r.checked;if(Array.isArray(o)){var s=t.id,i=e._i(o,s);r.checked?i<0&&e.$set(e.form,"templateIds",o.concat([s])):i>-1&&e.$set(e.form,"templateIds",o.slice(0,i).concat(o.slice(i+1)))}else e.$set(e.form,"templateIds",l)}}}),e._v(" "+e._s(t.name)+" ")])])})),0)],1),a("span",{staticStyle:{"font-size":"15px","font-weight":"1000",color:"#827f7f"}},[e._v(" 本地配置 ")]),a("div",{staticStyle:{border:"2px #dccece solid","border-style":"dashed","padding-top":"20px","padding-right":"20px","margin-top":"15px","margin-bottom":"15px"}},[a("a-form-model-item",{attrs:{label:"脚本内容",prop:"dirLocation","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-textarea",{staticStyle:{"background-color":"black",color:"wheat",width:"100%",height:"140px"},attrs:{name:"dirLocation",placeholder:"请输入解压源码包之后,把源码copy进项目结构的脚本",autocomplete:"off"},model:{value:e.form.dirLocation,callback:function(t){e.$set(e.form,"dirLocation",t)},expression:"form.dirLocation"}}),a("span",{staticStyle:{color:"red","font-size":"12px","line-height":"1px"}},[e._v(" * 注 : 脚本内容会生成bat脚本文件一并打包到最终的压缩包里,该脚本期望的逻辑实现为--解压源码包之后,执行该脚本,自动将源码copy进正确的项目结构目录中")])],1),a("a-form-model-item",{attrs:{label:"示例","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("div",{staticStyle:{background:"#ECECEC",padding:"30px"},attrs:{"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-card",{staticStyle:{width:"100%"},attrs:{title:"示例脚本",bordered:!1}},[a("p",[e._v("@echo off")]),a("p",[e._v('echo "starting copy resource code ..."')]),a("p",[e._v("xcopy *.* C:\\Users\\elvin\\Desktop\\11\\buukle-generator\\ /s /e /c /y /h /r")]),a("p",[e._v('echo "resource code copy finished !"')]),a("p",[e._v("pause")])])],1)])],1),a("span",{staticStyle:{"font-size":"15px","font-weight":"1000",color:"#827f7f"}},[e._v(" 其他配置 ")]),a("div",{staticStyle:{border:"2px #dccece solid","border-style":"dashed","padding-top":"20px","padding-right":"20px","margin-top":"15px","margin-bottom":"15px"}},[a("a-form-model-item",{attrs:{label:"备注",prop:"remark","label-col":e.formItemLayout.labelCol,"wrapper-col":e.formItemLayout.wrapperCol}},[a("a-textarea",{staticStyle:{width:"100%",height:"140px"},attrs:{name:"remark",placeholder:"remark",autocomplete:"off"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1)],1)],1),a("template",{slot:"footer"},[a("a-button",{attrs:{type:"primary"},on:{click:function(t){return e.handleEdit()}}},[e._v(" 提交 ")]),a("a-button",{on:{click:function(t){return e.handleClose()}}},[e._v(" 取消 ")])],1)],2)},r=[],l=(a("a15b"),a("2410")),s=a.n(l),i=a("b775"),m=a("f64c"),n={labelCol:{span:3},wrapperCol:{span:21}},c={components:{},props:{initvalue:{type:Object,default:null}},watch:{initvalue:function(){if(this.initvalue)for(var e in this.initvalue)this.form[e]=this.initvalue[e];else this.form=s()(this.initForm)},visible:function(e,t){if(!e)try{this.form=s()(this.initForm)}catch(a){}}},methods:{datasourcesChange:function(e,t){var a=this;this.form.datasourcesId=t.data.key,Object(i["b"])({url:"/datasources/getTablesList?id="+this.form.datasourcesId,method:"post",dataType:"json"}).then((function(e){"S"===e.head.status?(a.form.tableList=e.body.list,a.form.tables=[]):m["a"].error(e.head.msg)})).catch((function(e){console.log(e)}))},getDatasourcesList:function(){var e=this;Object(i["b"])({url:"/datasources/getDatasources",method:"post",dataType:"json"}).then((function(t){"S"===t.head.status?e.datasourcesList=t.body.list:m["a"].error(t.head.msg)})).catch((function(e){console.log(e)}))},getTitle:function(e){var t=this.$createElement;return t("span",e?[" 编辑 "]:[" 新建 "])},show:function(){this.visible=!0,this.getDatasourcesList()},handleClose:function(){this.form=s()(this.initForm),this.form.param="",this.visible=!1},handleEdit:function(){var e=this;this.$refs.form.validate((function(t){if(t){var a=JSON.parse(JSON.stringify(e.form));a.tables=a.tables.join(","),a.templateIds=a.templateIds.join(","),Object(i["b"])({url:"/configures/saveOrEdit",method:"post",dataType:"json",data:a}).then((function(t){"S"===t.head.status?(m["a"].success(t.head.msg),e.handleClose(),e.$emit("refresh")):m["a"].error(t.head.msg)})).catch((function(e){console.log(e)}))}}))}},data:function(){return{visible:!1,formLayout:"horizontal",formItemLayout:n,datasourcesList:[],form:{id:null,name:"",datasourcesId:"",datasourcesName:"",tables:[],templateIds:[],tableList:{},templatesList:{},basePackage:"",dirLocation:"",bak01:"",remark:""},initForm:{id:null,name:"",datasourcesId:"",datasourcesName:"",tables:[],templateIds:[],tableList:{},templatesList:{},basePackage:"",dirLocation:"",bak01:"",remark:""},rules:{name:[{required:!0,message:"请输入"},{max:50,message:"最多输入50个字符"},{pattern:/^(?!(\s+$))/,message:"输入格式错误"}],datasourcesName:[{required:!0,message:"请选择"}],tables:[{required:!0,message:"请选择表名(选择前请先选择连接)"}],templateIds:[{required:!0,message:"请选择模板"}],dirLocation:[{required:!0,message:"请输入脚本"}],basePackage:[{required:!0,message:"请输入"}]}}}},d=c,p=a("2877"),f=Object(p["a"])(d,o,r,!1,null,null,null);t["default"]=f.exports}}]);