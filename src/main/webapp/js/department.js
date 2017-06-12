var departmentTree={
	//存放节点
	data:{
		node:"",
		ztreeNode:""
	},
	setting:{
		isSimpleData: true,
		treeNodeKey: "did",
		treeNodeParentKey: "pid",
		showLine: true,
		nameCol:"dname",
		root:{ 
			isRoot:true,
			nodes:[]
		},
		callback:{//回调函数
			//右击树的回调功能
			rightClick:function(event, treeId, treeNode){
				//节点赋值
				departmentTree.data.node=treeNode;
				//显示div
				showRMenu("root",event.clientX, event.clientY);
			}
		}
	},
	//请求节点
	postdepartmenttree:function(){
		$.post("departmentjson_listDepartment",null,function(data){
			departmentTree.data.ztreeNode=$("#departmentTree").zTree(departmentTree.setting,data);
		});
	},
	//添加部门
	addDepartment:function(){
		//弹出div框获取填写的部门信息
		$("#adddepartment").show();
		//判断是否有值
//		if(rolename){
//			var crle={
//				name:rolename
//			};
//			//判断角色是否被占用
//			$.post("department_checkDepartment.action",crle,function(data){
//				if(data=="1"){
//					alert("部门名称被占用了！");
//				}else{
//					//封装数据
//					var paramer={
//						pid:roletree.data.node.rid,
//						name:rolename,
//						isParent:false
//					};
//					//添加角色请求
//					$.post("role_add.action",paramer,function(data){
//						alert(data.name);
//						//将返回的节点添加到父节点上面
//						roletree.data.zTreePlugin.addNodes(roletree.data.node,data,false);
//					});
//				}
//			});
//			
//		}
	},
	updateDepartment:function(){//修改角色
		//弹出确认框
		var rolename = window.prompt("请输入修改的名称！",roletree.data.node.name);
		if(rolename.length>0){
			//判断是否重名
			if(roletree.data.zTreePlugin.getNodeByParam("name",rolename)){
				alert("修改的角色已经存在，请重新修改！");
			}else{
				$.post("role_update",{
					rid:roletree.data.node.rid,
					name:rolename
				},function(data){
					roletree.data.node.name=rolename;
					roletree.data.zTreePlugin.refresh();
				});
			}
		}
	},
	//删除部门
	deleteDepartment:function(){
		if(window.confirm("确定要删除此部门？")){
			$.post("department_delete.action",{
				rid:roletree.data.node.rid
			},function(data){
				roletree.data.zTreePlugin.removeNode(roletree.data.node);
			});
		}
	},
	//初始化事件
	init:{
		initevent:function(){
			//添加部门
			$("#addDepartment").unbind("click");
			$("#addDepartment").bind("click",function(){
				departmentTree.addDepartment();
			});
			
			//修改部门
			$("#updateDepartment").unbind("click");
			$("#updateDepartment").bind("click",function(){
				departmentTree.updateDepartment();
			});
			
			//删除部门
			$("#deleteDepartment").unbind("click");
			$("#deleteDepartment").bind("click",function(){
				departmentTree.deleteDepartment();
			});
		}
	}
}
function showRMenu(type, x, y) {//显示div
	$("#rMenu ul").show();
	$("#rMenu").css({"top":y+"px", "left":x+"px", "display":"block"});
}
 

$(function(){
	//加载树
	departmentTree.postdepartmenttree();
	//初始化事件
	departmentTree.init.initevent();
	$("#rMenu").hover(function(){},
	function(){//移除
		$("#rMenu").hide();
	});
});