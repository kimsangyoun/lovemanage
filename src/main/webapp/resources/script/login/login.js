var login={
	 logout: function(){
		 $.ajax({
		        type : 'POST',
		        url : "../logout.do",
		        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
		        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
		    });
	 },
	 findUser : function(){
		 var obj = new Object();
		 var id = $("#uid").val();
		 obj.userId = id;

		 $.ajax({
		        type : 'POST',
		        url : '../user/finduser.do',
		        data : JSON.stringify(obj),
		        success : function (data) {
		            if (data) {
		            	if(data.resultCode=='200'){
		            		$( '#findTable > tbody').empty();
		            		if(!data.resultData){
		            			var td = $("<td colspan='3'>"+"데이터가 존재하지 않습니다."+"</td>");
		            			var tr = $("<tr></tr>").prepend(td);
		            			$("#findTable").prepend(tr);
		            		}else{
		            			login.drawtable(data.resultData);
		            		}
		            	}else{
		            		if(data.resultCode=='100'){
		            			alert(data.resultMsg);
		            		}else if(data.resultCode=='000'){
		            			$( '#findTable > tbody').empty();
		            			var td = $("<td colspan='3'>"+"데이터가 존재하지 않습니다."+"</td>");
		            			var tr = $("<tr></tr>").prepend(td);
		            			$("#findTable").prepend(tr);
		            		}
		            	}
		            }         
		        },
		        error : function(e){
		        	if(e.status==500 && e.responseText=="DuplicateKeyException"){
		        		alert("아이디 중복체크를 해주세요.");
		        	}
		        }
		    });
	 },
	 drawtable :function(data){
		 var innerBtn = $("<button type='button' class='btn'></button>").prepend("신청").attr("onclick","login.selectCouple('"+data.userId+"','Y');");
		 
		$("#findTable").find('tbody').append( "<tr><td>1</td><td>"+data.userId+"</td><td>"+innerBtn[0].outerHTML+"</td></tr>" );
	 },
	 signup: function(){
		 var obj = new Object();
		 var id = $("#uid").val();
		 var pwd = $("#upwd").val();
		 var nm = $("#unm").val();
		 obj.userId = id;
		 obj.userPwd = pwd;
		 obj.userNm = nm;
		 var urls = "${pageContext.request.contextPath}";
		 $.ajax({
		        type : 'POST',
		        url : './signup.do',
		        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
		       data : JSON.stringify(obj),
		      //data : {"userId" : id , "userPwd" : pwd, "userNm" : nm},
		        success : function (data) {
		            // 서버에서 Return된 값으로 중복 여부를 사용자에게 알려줍니다.
		            if (data) {
		            	if(data.resultCode=='200'){
		            		alert("회원 가입 성공!");
		            		location.href='${pageContext.request.contextPath}/login.do';
		            	}else{
		            		if(data.resultCode=='100'){
		            			alert(data.resultMsg);
		            		}else if(data.resultCode=='000'){
		            			alert(data.resultMsg);
		            		}
		            	}
		            }         
		        },
		        error : function(e){
		        	if(e.status==500 && e.responseText=="DuplicateKeyException"){
		        		alert("아이디 중복체크를 해주세요.");
		        	}
		        }

		    });
	 },
	 selectCouple : function(userId,type){
		 $("#myModal").modal("hide");
		 stateObject.coupleid = userId;
		 stateObject.requestType = type;
		 $("#coupleId").val(userId);
	
	 },
	 findRequest: function(userId){
		 var obj = new Object();
		 obj.userId = userId;

		 $.ajax({
		        type : 'POST',
		        url : '../user/findrequest.do',
		        data : JSON.stringify(obj),
		        success : function (data) {
		            if (data) {
		            	if(data.resultCode=='200'){
		            		if(!data.resultData || data.resultData.length ==0){
		            			var td = $("<td colspan='3'>"+"데이터가 존재하지 않습니다."+"</td>");
		            			var tr = $("<tr></tr>").prepend(td);
		            			$("#findTable").prepend(tr);
		            		}else{
			            		 for(var i =0; i< data.resultData.length;i++){
			            			 var innerBtn = $("<button type='button' class='btn'></button>").prepend("수락").attr("onclick","login.selectCouple('"+data.resultData[i].userId+"','N');");
				            	     var td1 = $("<td>"+(i+1)+"</td>");
				            	     var td2 = $("<td>"+data.resultData[i].userId+"</td>");
				            	     var td3 = $("<td></td>").prepend(innerBtn);
				            	     var tr = $("<tr></tr>").prepend(td3);
				            	     tr.prepend(td2);
				            	     tr.prepend(td1);
				            	     $("#findTable").prepend(tr);
			            		 }
		            		}
		            		$("#myModal").modal("show");
		            	}else{
		            		if(data.resultCode=='100'){
		            			alert(data.resultMsg);
		            		}else if(data.resultCode=='000'){
		            			alert(data.resultMsg);
		            		}
		            	}
		            }         
		        },
		        error : function(e){
		        	if(e.status==500 && e.responseText=="DuplicateKeyException"){
		        		alert("아이디 중복체크를 해주세요.");
		        	}
		        }
		    });
	 },
	 requestCouple: function(){
		 var obj = new Object();
		 obj.userId = stateObject.userid;
		 obj.coupleId = stateObject.coupleid;
		 
		 $.ajax({
		        type : 'POST',
		        url : '../user/couplerequest.do',
		        data : JSON.stringify(obj),
		        success : function (data) {
		            if (data) {
		            	if(data.resultCode=='200'){
		            		bootbox.alert({
		            		    message: "신청이 완료되었습니다. 상대분께서 수락시 서비스가 시작됩니다. 감사합니다.",
		            		    size: 'small',
		            		    callback: function () {
		            		    	location.href="../home/home.do";
		            		    }
		            		});
		            		
		            	}else{
		            		if(data.resultCode=='100'){
		            			alert(data.resultMsg);
		            		}else if(data.resultCode=='000'){
		            			alert(data.resultMsg);
		            		}
		            	}
		            }         
		        },
		        error : function(e){
		        	if(e.status==500 && e.responseText=="DuplicateKeyException"){
		        		alert("아이디 중복체크를 해주세요.");
		        	}
		        }
		    });
	 },
	 acceptRequest : function(){
		 var obj = new Object();
		 obj.userId = stateObject.userid;
		 obj.coupleId = stateObject.coupleid;
		 
		 $.ajax({
		        type : 'POST',
		        url : '../user/acceptrequest.do',
		        data : JSON.stringify(obj),
		        success : function (data) {
		            if (data) {
		            	if(data.resultCode=='200'){
		            		bootbox.alert({
		            		    message: "신청이 완료되었습니다. 상대분께서 수락시 서비스가 시작됩니다. 감사합니다.",
		            		    size: 'small',
		            		    callback: function () {
		            		    	location.href="../home/home.do";
		            		    }
		            		});
		            		
		            	}else{
		            		if(data.resultCode=='100'){
		            			alert(data.resultMsg);
		            		}else if(data.resultCode=='000'){
		            			alert(data.resultMsg);
		            		}
		            	}
		            }         
		        },
		        error : function(e){
		        	if(e.status==500 && e.responseText=="DuplicateKeyException"){
		        		alert("아이디 중복체크를 해주세요.");
		        	}
		        }
		    });
	 }
};