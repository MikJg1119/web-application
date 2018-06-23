<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-8 col-md-6 col-md-offset-3 col-xs-offset-1">
            <table class="table table-bordered table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Imie</th>
                    <th>Nazwisko</th>
                    <th>Email</th>
                    <th>Akcja</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items ="${usersList}">    
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td><a href="/users/edit?id=${user.id}" class="btn btn-primary">Edytuj</a></td>

                </tr>
                </c:forEach>
            
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
                  <div class="col-md-offset-3">
                      <a class="btn btn-primary" href="/users/create">Dodaj Użytkownika</a>
                  </div>
              </div>
    <div class="row">
        <div class="col-md-offset-3">
            <a class="btn btn-primary" href="menu.html">Powrót do menu</a>
        </div>
    </div>
</div>


</body>
</html>