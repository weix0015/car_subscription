// Get references to the input field and table rows
const searchInput = document.getElementById("searchInput");
const tableRows = document.querySelectorAll("tbody tr");

// Function to filter the table rows based on the search term
function filterRows() {
    const searchTerm = searchInput.value.toLowerCase();

    for (let i = 0; i < tableRows.length; i++) {
        const row = tableRows[i];
        let isMatch = false;

        for (let j = 0; j < row.cells.length; j++) {
            const cellValue = row.cells[j].textContent.toLowerCase();
            if (cellValue.includes(searchTerm)) {
                isMatch = true;
                break;
            }
        }

        if (isMatch) {
            row.style.display = ""; // Show matching rows
        } else {
            row.style.display = "none"; // Hide non-matching rows
        }
    }
}

// Add event listener to the search input field
searchInput.addEventListener("input", filterRows);