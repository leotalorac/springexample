<!DOCTYPE html>
<html lang="en">

<body>
    Time:  ${time}
<br>
    Message: ${message}
</body>

<script>
    fetch("/user")
        .then(response => response.json())
        .then(data => {
            let div = document.getElementById("show")
            data.forEach(e=>{
                let p = document.createElement('div');
                p.className = "name-user"
                p.innerText=e["name"];
                div.appendChild(p);
            })

        });
</script>
<style>
    .name-user{
        background-color: red;
    }
</style>

<div id="show">

</div>

<form action="">

</form>
</html>

