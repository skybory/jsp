window.onload = function() {
	let word = new Array();
	let obj = "";
	function sendJson3() {
		let xhr = new XMLHttpRequest();
		xhr.open("GET", "data2.json", true);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
				obj = JSON.parse(xhr.responseText);
				// obj 에서 search_word 라는 key 값을 가지고 value 를 꺼내오면
				//[{},{},{},{},{}] 이렇게 꺼내져온다.
				for (let i = 0; i<obj.search_word.length; i++) {
					word[i] = obj.search_word[i].name;
				}


			}
		};

	}

	let i = 0;
	setInterval(function(){
		sendJson3()
		i = i%obj.search_word.length;
		document.getElementById("td1").innerHTML = i+1;
		document.getElementById("td2").innerHTML = word[i];
		i++;
		},2000);

}