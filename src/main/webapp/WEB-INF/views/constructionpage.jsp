<!DOCTYPE html>

<head>
    <title>${showConstruction.name}</title>
</head>

<body>
    <h3>General information:</h3>
    <table border="1" cellpadding="5">
        <tr>
            <td>Construction site - ${showConstruction.name}</td>
            <td>code-number: ${showConstruction.codenumber}</td>
        </tr>
    </table>
    <h3>Description:</h3>
    <table>
        <td>${showConstruction.description}</td>
    </table>

    <p>
        <td><h3><a href="../construction/${showConstruction.name}/materials">Bill of materials</a></h3></td>
    </p>
    <p>
        <h3><a href="./orders">List of orders</a></h3>
    </p>
    <p>
        <input type="button" name="createorder" value="NEW ORDER">
    </p>
    <p>
        Note: this button should be available only for c-level, employees
    </p>
    <p>
        <h3><a href="../constructions">Back to list of constructions</a></h3>
    </p>
</body>

</html>