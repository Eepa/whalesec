const sounds = document.getElementById("sounds")

let whaleSounds = new XMLHttpRequest();
whaleSounds.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        let data = JSON.parse(whaleSounds.responseText);
        let ul = document.createElement('UL')

        if (data.length > 0) {
            data.forEach(function (sound) {
                let li = document.createElement('LI')
                li.innerHTML = sound;
                ul.appendChild(li);
            });
            sounds.innerHTML = "";
            sounds.appendChild(ul);
        } else sounds.innerHTML = "No sounds for whales!";

    } else sounds.innerHTML = "Could not load sounds!";
};
whaleSounds.open("GET", "http://whalesec.test.local:98/whales/sounds", true);
whaleSounds.send();

