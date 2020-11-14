<!DOCTYPE html>

<head>
    <title>${showConstruction.name}</title>
</head>

<body>
    <p>
        <h3>General information:</h3>
    <table border="1" cellpadding="5">
        <tr>
            <td>${showConstruction.codenumber}</td>
            <td>${showConstruction.name}</td>
        </tr>
    </table>
    <h3>Description:</h3>
    <table>
        <td>${showConstruction.description}</td>
    </table>

    </p>
    <p>
        <h3><a href="./materials">Bill of materials</a></h3>
    </p>
    <p>
        <h3><a href="./orders">List of orders</a></h3>
    </p>
    <p>
        <input type="button" name="createorder" value="NEW ORDER">
    </p>
    <p>
        Note: this button should be available only for foremans, shiefs
    </p>
    <p>
        and should not be available for suppliers
    </p>

    <p>
        <h3><a href="../constructions">Back to list of constructions</a></h3>
    </p>
</body>

</html>