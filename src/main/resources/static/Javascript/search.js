const searchInput = document.getElementById("searchInput");
const tableRows = document.querySelectorAll("tbody tr");

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
            row.style.display = "";
        } else {
            row.style.display = "none";
        }
    }
}

searchInput.addEventListener("input", filterRows);