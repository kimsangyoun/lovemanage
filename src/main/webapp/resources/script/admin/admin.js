var admin={
	 logout: function(){
		 
		 $.ajax({
		        type : 'POST',
		        url : "../logout.do",
		        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
		        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
		    });
	 }
};