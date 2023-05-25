const searchInput = document.getElementById("search-input");
const leftTableRows = document.querySelectorAll(".left-table tbody tr");
const rightTableRows = document.querySelectorAll(".right-table tbody tr");

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
            row.style.display = "";
        } else {
            row.style.display = "none";
        }
    });
}

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
            row.style.display = "";
        } else {
            row.style.display = "none";
        }
    });
}

searchInput.addEventListener("input", filterLeftTableRows);
searchInput.addEventListener("input", filterRightTableRows);
