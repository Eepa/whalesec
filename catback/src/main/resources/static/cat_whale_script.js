let xhr = new XMLHttpRequest();
xhr.open("POST", "http://whalesec.test.local:98/whales/sounds");
xhr.withCredentials = true;
xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
xhr.send('{"sound":"M4U!"}');




