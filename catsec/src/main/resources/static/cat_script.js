console.log("Mau!");

const noice = document.getElementById("noice")
noice.innerText = "Cat says: 'Mau!'"

let whaleGreeting = new XMLHttpRequest();
whaleGreeting.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        // Typical action to be performed when the document is ready:
        document.getElementById("whaleGreeting").innerHTML = whaleGreeting.responseText;
    } else document.getElementById("whaleGreeting").innerHTML = "Could not load whale greeting!";
};
whaleGreeting.open("GET", "http://whalesec.test.local:98/", true);
whaleGreeting.send();

