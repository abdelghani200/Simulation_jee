<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../components/header.jsp" />

<section class="container px-4 py-12 mx-auto h-full">
    <div class="flex justify-between items-center">
        <div class="flex items-center gap-x-3">
            <h2 class="text-lg font-medium text-gray-800 none:text-white">Credit requests</h2>

            <span class="px-3 py-1 text-xs text-blue-600 bg-blue-100 rounded-full none:bg-gray-800 none:text-blue-400">1 credit request</span>
        </div>
        <form id="filterForm" method="get" action="/creditRequests">
            <label class="block text-sm text-gray-500">Filter by Request Date</label>
            <select name="filterByStatus" id="status" class="block mt-2 w-full rounded-lg border border-gray-200 bg-white px-5 py-2.5 text-gray-700 focus:border-blue-400 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-40 ">
                <option value="Pending">Pending</option>
                <option value="Refused">Refused</option>
                <option value="Accepted">Accepted</option>
            </select>
            <button type="submit">Filter</button>
        </form>


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
                            <th scope="col" class="px-4 py-3.5 text-sm font-normal text-left rtl:text-right text-gray-500 none:text-gray-400">Monthly amount</th>
                            <th scope="col" class="px-4 py-3.5 text-sm font-normal text-left rtl:text-right text-gray-500 none:text-gray-400">Remarks</th>
                            <th scope="col" class="px-4 py-3.5 text-sm font-normal text-left rtl:text-right text-gray-500 none:text-gray-400">Status</th>
                            <th scope="col" class="relative py-3.5 px-4">
                                <span class="sr-only">Edit</span>
                            </th>
                        </tr>
                        </thead>
                        <tbody class="bg-white divide-y divide-gray-200 none:divide-gray-700 none:bg-gray-900" id="creditRequestsList">
                        <c:forEach items="${creditRequests}" var="creditRequest" >
                            <tr>
                                <td class="px-4 py-4 text-sm font-medium text-gray-700 whitespace-nowrap">${creditRequest.id}</td>
                                <td class="px-12 py-4 text-sm font-medium text-gray-700 whitespace-nowrap">${creditRequest.requestDate}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">${creditRequest.duration}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">${creditRequest.borrowedAmount}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">${creditRequest.monthlyAmount}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">${creditRequest.remark}</td>
                                <td class="px-4 py-4 text-sm text-gray-500 none:text-gray-300 whitespace-nowrap">${creditRequest.status}</td>
                                <td class="relative py-4 px-4">
                                    <a href="editCreditRequest.jsp?id=${creditRequest.id}" class="text-blue-600 hover:underline">Edit</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</section>


<script>
    document.getElementById("filterForm").addEventListener("submit", function (event) {
        event.preventDefault();

        var filterByStatus = document.getElementById("status").value;

        window.location.href = "/creditRequests?filterByStatus=" + filterByStatus;
    });


</script>


<c:import url="../components/footer.jsp" />
