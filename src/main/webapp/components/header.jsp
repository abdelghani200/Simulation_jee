<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="title" value="${requestScope.title}" />
    <title>EasyBank - ${title}</title>
    <!-- tailwind css -->
    <script src="${pageContext.request.contextPath}/resources/js/AjaxCalls.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<header>
    <nav class="bg-white shadow">
        <div class="px-6 py-4 mx-auto">
            <div class="flex items-center justify-center">
                <div class="absolute inset-x-0 z-20 w-full px-6 py-4 translate-x-0 opacity-100 transition-all duration-300 ease-in-out bg-white shadow-md lg:bg-transparent lg:none:bg-transparent lg:shadow-none none:bg-gray-900 lg:mt-0 lg:p-0 lg:top-0 lg:relative lg:w-auto lg:opacity-100 lg:translate-x-0">
                    <div class="-mx-4 lg:flex lg:items-center">
                        <a href="${pageContext.request.contextPath}/" class="block mx-4 text-gray-700 capitalize none:text-gray-200 hover:text-blue-600 none:hover:text-blue-400">Home</a>
                        <a href="${pageContext.request.contextPath}/creditRequests" class="block mx-4 mt-4 text-gray-700 capitalize lg:mt-0 none:text-gray-200 hover:text-blue-600 none:hover:text-blue-400">Credit request list</a>
                        <a href="${pageContext.request.contextPath}/creditRequestSimulation" class="block mx-4 mt-4 text-gray-700 capitalize lg:mt-0 none:text-gray-200 hover:text-blue-600 none:hover:text-blue-400">Simulation</a>
                    </div>
                </div>
            </div>
    </nav>
</header>