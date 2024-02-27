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

	if (userpw.length < 8) {
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


//function checkId(userid) {
//	if (userid == "") {
//		alert("아이디를 입력해주세요");
//		return false;
//	} else {
//		// ajax 통신
//		let xhr = new XMLHttpRequest();
//		//띄어쓰기 주의
//		xhr.open("GET", "idcheck.jsp?userid=" + userid, true);
//		xhr.send();
//		xhr.onreadystatechange = function() {
//			if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
//				// 만약 회원가입이 가능한 아이디라면
//				// join_view.jsp 에서 id="text"인 영역의 멘트를 수정함.
//
//							
//				if (xhr.responseText.trim() == "ok") {
//					$("#text").text("사용할 수 있는 아이디입니다.").css("color","green");
//				} else {
//					$("#text").text("중복된 아이디입니다");
//				}
//			}
//		};
//	}
//}
// 
// 
// function checkId2(userid){
//	 if(userid ==""){
//		 alert("아이디를 입력해주세요");
//		 return false;
//	 }	else {
//		 // jQuery 를 이용한 ajax 통신
//		 $.ajax({
//			 type	: 'get', // 타입 작성 (get,post)
//			 url	: 'idcheck.jsp?userid=' + userid,
//			 async	: true,	// 비동기화여부 (비동기 : true)
//			 success: function(result){	// 성공시 콜백함수
//				if (result.trim() == "ok") {
//					$("#text").text("사용할 수 있는 아이디입니다.").css("color","green");
//				} else {
//					$("#text").text("중복된 아이디입니다");
//				} 
//			 } ,
//			 error	: function(result, status, error){	// 실패시 콜백함수
//				 console.log(error);
//			 }
//		 });
//		 
//	 }
// }
// 
// 
function checkId3(userid) {
	if (userid == "") {
		alert("아이디를 입력해주세요");
		return false;
	} else {
		// jQuery 를 이용한 ajax 통신
		$.ajax({
			type: 'post', // 타입 작성 (get,post)
			url: 'idcheck.jsp',
			data: { "userid": userid },
			async: true,	// 비동기화여부 (비동기 : true)
			success: function(result) {	// 성공시 콜백함수
				if (result.trim() == "ok") {
					$("#text").text("사용할 수 있는 아이디입니다.").css("color", "green");
				} else {
					$("#text").text("중복된 아이디입니다");
				}
			},
			error: function(result, status, error) {	// 실패시 콜백함수
				console.log(error);
			}
		});

	}
}



function DaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById("daum_extraAddress").value = extraAddr;

			} else {
				document.getElementById("daum_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById("daum_postcode").value = data.zonecode;
			document.getElementById("daum_address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("daum_detailAddress").focus();
		}
	}).open();
}


