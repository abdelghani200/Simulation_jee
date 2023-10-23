<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../components/header.jsp" />

<section class="container px-4 py-12 mx-auto h-full">
    <div class="flex justify-between items-center">
        <div class="flex items-center gap-x-3">
            <h2 class="text-lg font-medium text-gray-800 none:text-white">Credit requests</h2>
    
            <span class="px-3 py-1 text-xs text-blue-600 bg-blue-100 rounded-full none:bg-gray-800 none:text-blue-400">1 credit request</span>
        </div>                
        <div>
            <label for="Request_date" class="block text-sm text-gray-500">Request Date</label>
            <input type="date" class="block  mt-2 w-full placeholder-gray-400/70  rounded-lg border border-gray-200 bg-white px-5 py-2.5 text-gray-700 focus:border-blue-400 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-40 " />
        </div>  
    </div>

    <div class="flex flex-col mt-6">
        <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
            <div class="inline-block min-w-full py-2 align-middle md:px-6 lg:px-8">
                <div class="overflow-hidden border border-gray-200 none:border-gray-700 md:rounded-lg">
                    <table class="min-w-full divide-y divide-gray-200 none:divide-gray-700">
                        <thead class="bg-gray-50 none:bg-gray-800">
                            <tr>
                                <th scope="col" class="py-3.5 px-4 text-sm font-normal text-left rtl:text-right text-gray-500 none:text-gray-400">
                                    <div class="flex items-center gap-x-3">
                                        <span>Id</span>
                                    </div>
                                </th>

                                <th scope="col" class="px-12 py-3.5 text-sm font-normal text-left rtl:text-right text-gray-500 none:text-gray-400">
                                    Request date
                                </th>
                                
                                <th scope="col" class="px-4 py-3.5 text-sm font-normal text-left rtl:text-right text-gray-500 none:text-gray-400">
                                    Duration
                                </th>

                                <th scope="col" class="px-4 py-3.5 text-sm font-normal text-left rtl:text-right text-gray-500 none:text-gray-400">Borrowed amount</th>

                                <th scope="col" class="px-4 py-3.5 text-sm font-normal text-left rtl:text-right text-gray-500 none:text-gray-400">Status</th>

                                <th scope="col" class="relative py-3.5 px-4">
                                    <span class="sr-only">Edit</span>
                                </th>
                            </tr>
                        </thead>
                        <tbody class="bg-white divide-y divide-gray-200 none:divide-gray-700 none:bg-gray-900">
                            <tr>
                                <td class="px-4 py-4 text-sm font-medium text-gray-700 whitespace-nowrap">{creditRequest.id}</td>
                                <td class="px-12 py-4 text-sm font-medium text-gray-700 whitespace-nowrap">{creditRequest.requestDate}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">{creditRequest.duration}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">{creditRequest.borrowedAmount}</td>
                                <td class="px-4 py-4 text-sm whitespace-nowrap">
                                    <div class="inline-flex items-center px-3 py-1 rounded-full gap-x-2 bg-blue-100/60 none:bg-gray-800">
                                        <span class="h-1.5 w-1.5 rounded-full bg-blue-500"></span>

                                        <h2 class="text-sm font-normal text-blue-500">Pending</h2>
                                    </div>
                                </td>
                                <td class="px-4 py-4 text-sm whitespace-nowrap">
                                    <div class="flex items-center gap-x-6">
                                        <button class="text-gray-500 transition-colors duration-200 none:hover:text-red-500 none:text-gray-300 hover:text-red-500 focus:outline-none">
                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5">
                                                <path stroke-linecap="round" stroke-linejoin="round" d="M14.74 9l-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 01-2.244 2.077H8.084a2.25 2.25 0 01-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 00-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 013.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 00-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 00-7.5 0" />
                                            </svg>
                                        </button>

                                        <button class="text-gray-500 transition-colors duration-200 none:hover:text-yellow-500 none:text-gray-300 hover:text-yellow-500 focus:outline-none">
                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5">
                                                <path stroke-linecap="round" stroke-linejoin="round" d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L10.582 16.07a4.5 4.5 0 01-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 011.13-1.897l8.932-8.931zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0115.75 21H5.25A2.25 2.25 0 013 18.75V8.25A2.25 2.25 0 015.25 6H10" />
                                            </svg>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="px-4 py-4 text-sm font-medium text-gray-700 whitespace-nowrap">{creditRequest.id}</td>
                                <td class="px-12 py-4 text-sm font-medium text-gray-700 whitespace-nowrap">{creditRequest.requestDate}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">{creditRequest.duration}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">{creditRequest.borrowedAmount}</td>
                                <td class="px-4 py-4 text-sm whitespace-nowrap">
                                    <div class="inline-flex items-center px-3 py-1 rounded-full gap-x-2 bg-red-100/60 none:bg-gray-800">
                                        <span class="h-1.5 w-1.5 rounded-full bg-red-500"></span>

                                        <h2 class="text-sm font-normal text-red-500">Refused</h2>
                                    </div>
                                </td>
                                <td class="px-4 py-4 text-sm whitespace-nowrap">
                                    <div class="flex items-center gap-x-6">
                                        <button class="text-gray-500 transition-colors duration-200 none:hover:text-red-500 none:text-gray-300 hover:text-red-500 focus:outline-none">
                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5">
                                                <path stroke-linecap="round" stroke-linejoin="round" d="M14.74 9l-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 01-2.244 2.077H8.084a2.25 2.25 0 01-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 00-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 013.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 00-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 00-7.5 0" />
                                            </svg>
                                        </button>

                                        <button class="text-gray-500 transition-colors duration-200 none:hover:text-yellow-500 none:text-gray-300 hover:text-yellow-500 focus:outline-none">
                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5">
                                                <path stroke-linecap="round" stroke-linejoin="round" d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L10.582 16.07a4.5 4.5 0 01-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 011.13-1.897l8.932-8.931zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0115.75 21H5.25A2.25 2.25 0 013 18.75V8.25A2.25 2.25 0 015.25 6H10" />
                                            </svg>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="px-4 py-4 text-sm font-medium text-gray-700 whitespace-nowrap">{creditRequest.id}</td>
                                <td class="px-12 py-4 text-sm font-medium text-gray-700 whitespace-nowrap">{creditRequest.requestDate}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">{creditRequest.duration}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">{creditRequest.borrowedAmount}</td>
                                <td class="px-4 py-4 text-sm whitespace-nowrap">
                                    <div class="inline-flex items-center px-3 py-1 rounded-full gap-x-2 bg-green-100/60 none:bg-gray-800">
                                        <span class="h-1.5 w-1.5 rounded-full bg-green-500"></span>

                                        <h2 class="text-sm font-normal text-green-500">Accepted</h2>
                                    </div>
                                </td>
                                <td class="px-4 py-4 text-sm whitespace-nowrap">
                                    <div class="flex items-center gap-x-6">
                                        <button class="text-gray-500 transition-colors duration-200 none:hover:text-red-500 none:text-gray-300 hover:text-red-500 focus:outline-none">
                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5">
                                                <path stroke-linecap="round" stroke-linejoin="round" d="M14.74 9l-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 01-2.244 2.077H8.084a2.25 2.25 0 01-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 00-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 013.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 00-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 00-7.5 0" />
                                            </svg>
                                        </button>

                                        <button class="text-gray-500 transition-colors duration-200 none:hover:text-yellow-500 none:text-gray-300 hover:text-yellow-500 focus:outline-none">
                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5">
                                                <path stroke-linecap="round" stroke-linejoin="round" d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L10.582 16.07a4.5 4.5 0 01-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 011.13-1.897l8.932-8.931zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0115.75 21H5.25A2.25 2.25 0 013 18.75V8.25A2.25 2.25 0 015.25 6H10" />
                                            </svg>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="flex items-center justify-between mt-6">
        <a href="#" class="flex items-center px-5 py-2 text-sm text-gray-700 capitalize transition-colors duration-200 bg-white border rounded-md gap-x-2 hover:bg-gray-100 none:bg-gray-900 none:text-gray-200 none:border-gray-700 none:hover:bg-gray-800">
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5 rtl:-scale-x-100">
                <path stroke-linecap="round" stroke-linejoin="round" d="M6.75 15.75L3 12m0 0l3.75-3.75M3 12h18" />
            </svg>

            <span>
                previous
            </span>
        </a>

        <div class="items-center hidden lg:flex gap-x-3">
            <a href="#" class="px-2 py-1 text-sm text-blue-500 rounded-md none:bg-gray-800 bg-blue-100/60">1</a>
            <a href="#" class="px-2 py-1 text-sm text-gray-500 rounded-md none:hover:bg-gray-800 none:text-gray-300 hover:bg-gray-100">2</a>
            <a href="#" class="px-2 py-1 text-sm text-gray-500 rounded-md none:hover:bg-gray-800 none:text-gray-300 hover:bg-gray-100">3</a>
            <a href="#" class="px-2 py-1 text-sm text-gray-500 rounded-md none:hover:bg-gray-800 none:text-gray-300 hover:bg-gray-100">...</a>
            <a href="#" class="px-2 py-1 text-sm text-gray-500 rounded-md none:hover:bg-gray-800 none:text-gray-300 hover:bg-gray-100">12</a>
            <a href="#" class="px-2 py-1 text-sm text-gray-500 rounded-md none:hover:bg-gray-800 none:text-gray-300 hover:bg-gray-100">13</a>
            <a href="#" class="px-2 py-1 text-sm text-gray-500 rounded-md none:hover:bg-gray-800 none:text-gray-300 hover:bg-gray-100">14</a>
        </div>

        <a href="#" class="flex items-center px-5 py-2 text-sm text-gray-700 capitalize transition-colors duration-200 bg-white border rounded-md gap-x-2 hover:bg-gray-100 none:bg-gray-900 none:text-gray-200 none:border-gray-700 none:hover:bg-gray-800">
            <span>
                Next
            </span>

            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-5 h-5 rtl:-scale-x-100">
                <path stroke-linecap="round" stroke-linejoin="round" d="M17.25 8.25L21 12m0 0l-3.75 3.75M21 12H3" />
            </svg>
        </a>
    </div>
</section>
<!-- <div class="container">
    <h1>Liste des Credits</h1>
    <form method="GET" action="${pageContext.request.contextPath}/Employes" class="search-form">
        <input type="text" name="action" value="search" hidden>
        <input type="text" name="query" class="search-input" placeholder="Rechercher des employes">
        <button type="submit" class="search-button">Rechercher</button>
    </form>
    <table>
        <thead>
        <tr>
            <th>numero</th>
            <th>montant</th>
            <th>remarques</th>
            <th>duree</th>
            <th>etat</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="credit" items="${creditRequests}" >
            <tr>
                <td>${credit.id}</td>
                <td>${credit.borrowedAmount}</td>
                <td>${credit.remark}</td>
                <td>${credit.duration}</td>
                <td>${credit.status}</td>
                <td>
                    <c:url value='${pageContext.request.contextPath}/Credits?action=edit&numero=${credit.id}' var="editEmployeURL" />
                    <a href="${editEmployeURL}" class="icon-link green">
                        <i class="fas fa-edit"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div> -->

<c:import url="../components/footer.jsp" />
