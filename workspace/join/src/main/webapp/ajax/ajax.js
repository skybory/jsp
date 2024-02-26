/**
 *  get 방식 ajax
 */


// 실습시간에 jQuery 로 해보기
// <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

function send1() {
	let xhr = new XMLHttpRequest();
	// open(전달방식,url주소값,동기 여부(비동기 : true(기본값), 동기 : false))
	xhr.open("GET", "request_ajax.jsp?userid=admin&userpw=1234", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		//통신에 성공했을 때
		if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
			document.getElementById("result").innerHTML
				= xhr.responseText;
			//			alert(xhr.responseText)
		}
	};
}

function send2() {
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "request_ajax.jsp", true);
	//get 방식에는 없는 식 추가해줘야함
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	//get 방식과 형태가 다름 + 일부러 post값임을 강조하기 위해 출력값을 조작해둠.
	xhr.send("userid=postadmin&userpw=post1234");

	// 마찬가지로 통신에 성공했을 때 아래의 결과를 비동기적으로 출력해줌.
	xhr.onreadystatechange = function() {
		if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
			document.getElementById("result").innerHTML
				= xhr.responseText;
		}
	};
}



function sendJson() {
	let xhr = new XMLHttpRequest();

	// open(전달방식,url주소값,동기 여부(비동기 : true(기본값), 동기 : false))
	xhr.open("GET", "data.json", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		//통신에 성공했을 때
		if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
			alert(xhr.responseText);
		let obj = JSON.parse(xhr.responseText);
		alert(obj);
		alert(obj.count);
		alert(obj.result);
		}
	};

}


function sendJson2() {
	let xhr = new XMLHttpRequest();

	xhr.open("GET", "data2.json", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		//통신에 성공했을 때
		if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
			let obj = JSON.parse(xhr.responseText);



			let i = 0;
			let interval = setInterval(function() {
				
				$("#td1").text(obj.search_word[i % 5].rank);
				$("#td2").text(obj.search_word[i % 5].name);
				i++;
			}, 2000);

			setTimeout(function() {
				clearInterval(interval);
			},4000);


		};

	}
}
