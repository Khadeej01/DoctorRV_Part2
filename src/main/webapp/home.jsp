<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        body{
            background-image: url('https://images2.imgbox.com/cb/1b/Rzo49As9_o.jpg');
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to DoctorRV</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-black flex items-center justify-center min-h-screen">

<div class="text-white text-center">
    <h1 class="text-3xl text-blue-700 font-bold mb-8">WELCOME TO DOCTORRV</h1>

    <div class="flex gap-8">

        <div class="bg-while-700 p-6 rounded-lg shadow-md w-80">
            <h2 class="text-lg font-semibold mb-4">Are you a Doctor? Login here</h2>
            <form action="LoginServlet" method="POST">
                <input type="text" name="username" placeholder="Username..." class="w-full px-4 py-2 mb-3 rounded bg-gray-800 text-white focus:outline-none focus:ring-2 focus:ring-green-500">
                <input type="password" name="password" placeholder="Password..." class="w-full px-4 py-2 mb-3 rounded bg-gray-800 text-white focus:outline-none focus:ring-2 focus:ring-green-500">
                <button type="submit" class="w-full bg-green-600 hover:bg-green-700 text-white py-2 rounded">Login</button>
            </form>
            <p class="mt-3 text-sm">
                You don’t have an account? <a href="DocRegister" class="text-green-400">Create account</a>
            </p>
        </div>


        <div class="bg-white-700 p-6 rounded-lg shadow-md w-80">
            <h2 class="text-lg font-semibold mb-4">Are you a Patient? Login here</h2>
            <form action="LoginServlet" method="POST">
                <input type="text" name="username" placeholder="Username..." class="w-full px-4 py-2 mb-3 rounded bg-gray-800 text-white focus:outline-none focus:ring-2 focus:ring-green-500">
                <input type="password" name="password" placeholder="Password..." class="w-full px-4 py-2 mb-3 rounded bg-gray-800 text-white focus:outline-none focus:ring-2 focus:ring-green-500">
                <button type="submit" class="w-full bg-green-600 hover:bg-green-700 text-white py-2 rounded">Login</button>
            </form>
            <p class="mt-3 text-sm">
                You don’t have an account? <a href="/register" class="text-green-400">Create account</a>
            </p>
        </div>
    </div>
</div>

</body>
</html>