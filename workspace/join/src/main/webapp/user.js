 function sendit() {
	 
//	 let frm = document.joinForm;
//	 let userid2= frm.userid;
//	 let userpw2= frm.userpw;
//	 let userpw_re2=frm.userpw_re;
//	 let username2= frm.username;
//	 let userphone2 = frm.userphone;
	 
	 let userid = $("#userid").val();
	 let userpw = $("#userpw").val();
	 let userpw_re = $("#userpw_re").val();
	 let userphone = $("#userphone").val();
	 let username = $("#username").val();
	 if (!userid) {
		 alert("아이디를 입력해주세요");
		 $("#userid").focus();
		 return false;
	 }
	 
	 if (userid.length < 5 || userid.length > 16) {
		 alert("아이디는 5자리 이상, 16자리 미만으로 작성");
		 $("#userid").focus();
		 return false;

	 }
	 if (!userpw) {
		 alert("비밀번호를 입력해주세요");
		$("#userpw").focus();
		 return false;

	 }
	 
	 if (userpw.length < 8 ){
		 alert("비밀번호는 8자리 이상으로 작성하세요");
		 $("#userpw").focus();
		 return false;
		 
	 }
	 
	 if (userpw != userpw_re) {
		 alert("비밀번호와 일치하지 않습니다");
		 $("#userpw_re").focus();
		 return false;
		 
		 
	 }
	 if (!username) {
		 alert("이름을 입력해주세요");
		 $("#username").focus();
		 return false;
	 }
	 if (!userphone) {
		 alert("휴대폰번호를 입력해주세요");
		 $("#userphone").focus();
		 return false;
	 }
	 
	 
	 
	 // 아이디 빈값체크	-> alert 아이디를 입력해주세요!
	 // 아이디 길이체크	-> alert 아이디는 5자리 이상, 16자리 미만으로 작성
	 // 비밀번호 빈값체크	-> alert 비밀번호를 입력하세요!
	 // 비밀번호 자리체크	-> alert 비밀번호는 8자리 이상으로 입력
	 // 비밀번호 == 비밀번호 확인 -> alert 비밀번호와 일치하지 않습니다.
	 // 이름 빈값체크	-> alert 이름을 입력하세요!
	 // 휴대폰번호 빈값체크	-> alert 휴대폰번호를 입력하세요!
	 // submit();
	 
	 
	 $("#joinForm").submit();
	 
 }
 
 
 
 
 
 
 function loginit() {
	 let frm = document.frm;
	 
	 
	 let userid = $("#userid").val();
	 let userpw = $("#userpw").val();
	 
	  if (!userid) {
		 alert("아이디를 입력해주세요");
		 $("#userid").focus();
		 return false;
	 }
	 
	  if (!userpw) {
		 alert("패스워드를 입력해주세요");
		 $("#userpw").focus();
		 return false;
	 }
	 
	 frm.submit();
//	  $("#joinForm").submit();
	 
	 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 