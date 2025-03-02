<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        body{
            background-image: url('https://images2.imgbox.com/cb/1b/Rzo49As9_o.jpg');
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patient Account Creation</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-black flex items-center justify-center min-h-screen">

<div class="text-white text-center">
    <h1 class="text-3xl text-blue-700 font-bold mb-8">Patient Account Creation</h1>

    <div class="bg-white-700 p-6 rounded-lg shadow-md w-80">
        <form action="CreateAccountServlet" method="POST">

            <input type="text" name="username" placeholder="Username..." class="w-full px-4 py-2 mb-3 rounded bg-gray-800 text-white focus:outline-none focus:ring-2 focus:ring-green-500">
            <input type="email" name="email" placeholder="Email..." class="w-full px-4 py-2 mb-3 rounded bg-gray-800 text-white focus:outline-none focus:ring-2 focus:ring-green-500">
            <input type="password" name="password" placeholder="Password..." class="w-full px-4 py-2 mb-3 rounded bg-gray-800 text-white focus:outline-none focus:ring-2 focus:ring-green-500">
            <input type="text" name="telephone" placeholder="Telephone..." class="w-full px-4 py-2 mb-3 rounded bg-gray-800 text-white focus:outline-none focus:ring-2 focus:ring-green-500">
            <button type="submit" class="w-full bg-green-600 hover:bg-green-700 text-white py-2 rounded">Create Account</button>
        </form>
        <p class="mt-3 text-sm">
            Already have an account? <a href="home.jsp" class="text-green-400">Login</a>
        </p>
    </div>
    <a href="LogoutServlet" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
        Logout
    </a>

</div>

</body>
</html>
