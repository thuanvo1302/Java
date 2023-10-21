<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
            <form method="post" action="login" class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input name="username" id="username" type="text" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input name="password" id="password" type="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="rememberMe">
                    <label class="form-check-label" for="rememberMe">Remember me</label>
                </div>
                <div class="form-group">
                    <button class="btn btn-success px-5">Login</button>
                </div>
                <div class="form-group">
                    <p>Register? <a href="register.jsp">Click here</a></p>
                </div>
            </form>

        </div>
    </div>
</div>
<script>
    // JavaScript to set the "Remember Me" cookie
    document.addEventListener("DOMContentLoaded", function () {
        const rememberMeCheckbox = document.getElementById("rememberMe");
        const usernameInput = document.getElementById("username");
        const passwordInput = document.getElementById("password");

        // Check if the user has previously selected "Remember Me"
        if (document.cookie.includes("rememberMe=true")) {
            rememberMeCheckbox.checked = true;
            // Populate the input fields with remembered values
            const usernameCookie = getCookie("username");
            const passwordCookie = getCookie("password");
            if (usernameCookie && passwordCookie) {
                usernameInput.value = usernameCookie;
                passwordInput.value = passwordCookie;
            }
        }

        // Function to get a cookie by name
        function getCookie(name) {
            const cookies = document.cookie.split("; ");
            for (const cookie of cookies) {
                const [cookieName, cookieValue] = cookie.split("=");
                if (cookieName === name) {
                    return decodeURIComponent(cookieValue);
                }
            }
            return null;
        }

        // Event listener to update cookies when the "Remember Me" checkbox is changed
        rememberMeCheckbox.addEventListener("change", function () {
            if (rememberMeCheckbox.checked) {
                const username = usernameInput.value;
                const password = passwordInput.value;
                document.cookie = `rememberMe=true; expires=30d; path=/`;
                document.cookie = `username=${username}; expires=30d; path=/`;
                document.cookie = `password=${password}; expires=30d; path=/`;
            } else {
                // Clear the "Remember Me" cookies
                document.cookie = "rememberMe=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
                document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
                document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
            }
        });
    });
</script>
</body>
</html>
