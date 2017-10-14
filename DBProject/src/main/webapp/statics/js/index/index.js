$(function() {
	console.log(JSON.parse(sessionStorage.getItem("userInfo")).menu);

});

BUI.use('#', function() {
	var config = [{id:'1',menu:[{items:[{href:"../menu/menulist.html",id:'2',text:"菜单列表"},{href:"../user/userlist.html",id:'1',text:"用户列表"},{href:"../role/rolelist.html",id:'1',text:"角色列表"}],text:"系统管理"}]},{id:'1',menu:[{items:[],text:"新番管理"},{items:[],text:"数据管理"}]}]
	new PageUtil.MainPage({
		modulesConfig : config
	});
});

var indexvue = new Vue(
		{
			el : '#indextop',
			data : {
				username : JSON.parse(sessionStorage.getItem("userInfo")).user.useraccount
			},
			methods : {
				loginout : function() {
					$.getJSON('logout', function(data) {
						if (data.code = 200) {
							location.href = 'login.html';
						} else {
							layer.msg('退出登录失败！');
						}
					});

				}
			}

		});