

$(function(){
	
	 $.ajax({
			type:"post",//提交方式
			url:"/error/errorValue",//提交路径
			//dataType:"json",//数据处理方式
			//data:{ "phone":phone,"pwd":userpwd },//提交参数
	        async:false, //默认是true：异步，false：同步。
			success:function(data){
				//debugger;
				if(data.status == 200 && data.msg == "ok"){
					alert("success");
				}else{
					alert("发生异常："+data.msg)
				}
				
			},
			error:function(response, ajaxOptions, thrownError){
				alert("error");
			}

		});
	
	
})