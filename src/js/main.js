function myFunction() {
  console.log("hi");
  var urlnow = document.getElementById("url1").value;
  const Http = new XMLHttpRequest();
  const url='http://localhost:8080/'+urlnow;
  Http.open("PUT", url);
  Http.send();
  console.log("url", url);
  Http.onreadystatechange=(e)=>{
    console.log(urlnow);
    console.log(Http.responseText);
    const testing = Json.parse(Http.responseText);
    console.log(testing["tinyUrl"]);
    console.log(Http.response)
  }
}
