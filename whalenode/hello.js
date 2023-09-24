const http = require('http');

const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {

    res.setHeader("Location", "http://127.0.0.1:3000/DQ0=1");
    // res.writeHead(302, {
    //     Location: `http://127.0.0.1:3000/\u{010D}\u{010A}1`
    // }).end();
    res.statusCode = 301;
    res.end();
});

server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});
