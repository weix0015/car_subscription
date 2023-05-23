
    // Get references to the input field and table rows
    const searchInput = document.getElementById("search-input");
    const leftTableRows = document.querySelectorAll(".left-table tbody tr");
    const rightTableRows = document.querySelectorAll(".right-table tbody tr");

    // Function to filter the left table rows based on the search term
    function filterLeftTableRows() {
    const searchTerm = searchInput.value.toLowerCase();

    leftTableRows.forEach((row) => {
    let matchFound = false;
    const cells = row.getElementsByTagName("td");

    for (let i = 0; i < cells.length; i++) {
    const cellContent = cells[i].textContent.toLowerCase();
    if (cellContent.includes(searchTerm)) {
    matchFound = true;
    break;
}
}

    if (matchFound) {
    row.style.display = ""; // Show matching rows
} else {
    row.style.display = "none"; // Hide non-matching rows
}
});
}

    // Function to filter the right table rows based on the search term
    function filterRightTableRows() {
    const searchTerm = searchInput.value.toLowerCase();

    rightTableRows.forEach((row) => {
    let matchFound = false;
    const cells = row.getElementsByTagName("td");

    for (let i = 0; i < cells.length; i++) {
    const cellContent = cells[i].textContent.toLowerCase();
    if (cellContent.includes(searchTerm)) {
    matchFound = true;
    break;
}
}

    if (matchFound) {
    row.style.display = ""; // Show matching rows
} else {
    row.style.display = "none"; // Hide non-matching rows
}
});
}

    // Add event listener to the search input field for both tables
    searchInput.addEventListener("input", filterLeftTableRows);
    searchInput.addEventListener("input", filterRightTableRows);
