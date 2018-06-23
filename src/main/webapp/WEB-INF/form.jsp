<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-md-offset-2">
        <div>
            <form action="/zapisz-szkolenie" method="get" class="form-horizontal">
                <div class="form group">
                <label for ="nazwa" class="col-sm-2 control-label">Imie:</label>
                    <div class="col-md-10">
                        <input id="nazwa" name="nazwa" placeholder="zabij się" class="form-control">
                    </div>

                </div>
                <div class="form group">
                <label for ="cena" class="col-sm-2 control-label">Nazwisko:</label>
                    <div class="col-md-10">
                <input id="cena" name="cena" placeholder="i tak Cię nie stać biedaku" class="form-control">
                    </div>

                </div>
                <div class="form group">
                                <label for ="nazwa" class="col-sm-2 control-label">Email:</label>
                                    <div class="col-md-10">
                                        <input id="nazwa" name="nazwa" placeholder="Email" class="form-control">
                                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Zapisz</button>
                    </div>
                </div>


                <a class="btn btn-danger col-md-offset-2" href="menu.html">Powrót do tabeli</a>

            </form>

        </div>

    </div>

</div>


</body>
</html>