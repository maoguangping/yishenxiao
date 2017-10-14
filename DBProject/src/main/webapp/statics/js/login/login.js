$(function(){
	sessionStorage.clear();//到了登录页面，当前窗口清空session登录信息 
});

var loginvue = new Vue({
  el:'#logintop',
  data:{
	  errorinfo:false,
      errorMsg:'',
      loginusername:'',
      loginpassword:'',
      logincaptcha:'',
      loginimgsrc:'captcha'
  },
  methods:{
	  refreshCode:function(){
		  $("#loginbutton").text("登录");	
		  this.src = "captcha?t=" + $.now();	
		  $("#srccaptcha").attr("src", "");//点击有点变化
		  $("#srccaptcha").attr("src", this.src);
	  },
	  login:function(e){
		  loginvue.errorinfo=false;
		  $("#loginbutton").text("登录中...");
		  if(!this.loginusername){
			  $("#loginbutton").text("登录");	
			  loginvue.errorMsg = '账号不能为空!';
			  loginvue.errorinfo=true;
			  return;
		  }
		  if(!this.loginpassword){
			  $("#loginbutton").text("登录");	
			  loginvue.errorMsg = '密码不能为空!';
			  loginvue.errorinfo=true;
			  return;
		  }
		  if(!this.logincaptcha){
			  $("#loginbutton").text("登录");	
			  loginvue.errorMsg = '验证码不能为空!';
			  loginvue.errorinfo=true;
			  return;
		  }
		  var data = "loginusername="+this.loginusername+"&loginpassword="+this.loginpassword+"&logincaptcha="+this.logincaptcha;
		  $.ajax({
				type: "POST",
			    url: "checklogin",
			    data: data,
			    dataType: "json",
			    async:true,
			    success: function(result){
					if(result.code == 200){					
						console.log(result.msg);
						sessionStorage.setItem("userInfo",JSON.stringify(result.msg));
						console.log(JSON.parse(sessionStorage.getItem("userInfo")).menu);
						//parent.location.href = "page/main?type=main";
						parent.location.href = "index.html";
						$("#loginbutton").text("登录");
					}else{
						loginvue.errorMsg = result.msg;
						loginvue.errorinfo = true;
						$("#loginbutton").text("登录");		
						loginvue.refreshCode();
					}
				}
			});
	  }
  }
});
