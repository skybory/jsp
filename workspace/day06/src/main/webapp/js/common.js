function sendit(){
	// 아이디 빈 값 -> alert "아이디를 입력하세요!"
	// 비밀번호 빈 값 -> alert "비밀번호를 입력하세요!"
	// 비밀번호 8자리 이상 체크 -> alert "비밀번호를 8자리 이상입력하세요!"
	// 이름 빈값 체크 -> alert "이름을 입력하세요"
	// 휴대폰번호 빈값 체크 -> alert "휴대폰 번호를 입력하세요!
	// 전부 입력 후, submit
	let frm = document.getElementById("joinForm");
	// 바닐라 스크립트로 form 불러오기, 이러면 마지막에
	// frm.submit() 하면됨
	let userid = $("#userid").val();
	let userpw = $("#userpw").val();
	let username = $("#username").val();
	let userphone = $("#userphone").val();
	
	
if(!userid) {
	alert("아이디를 입력하세요!")
	$("#userid").focus();
	return false;
}
if(!userpw) {
	alert("비밀번호를 입력하세요!")
	$("#userpw").focus();
	return false;
}
if(userpw.length<8){
	alert("비밀번호를 8자리 이상 입력하세요!")
	$("#userpw").focus();
	return false;
}
if(!username) {
	alert("이름을 입력하세요!")
	$("#username").focus();
	return false;
}
if(!userphone) {
	alert("휴대폰 번호를 입력하세요!")
	$("#userphone").focus();
	return false;
}
	

$("#joinForm").submit();
//frm.submit();

}
