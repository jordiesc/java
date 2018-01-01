<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webresources/common/header.jspf"%>

<div id="wrapper">
    <%@ include file="/webresources/common/navigationbar.jspf"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5><i class="fa fa-plus-square fa-fw"></i> <b> Create a new Hora </b></h5>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="${appPath}/hora/new" method="POST">
                                    <div class="form-group">
                                        <label for="hora">Hora</label>
                                        <input class="form-control" type="number" name="hora" path="hora"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="mes">Mes</label>
                                        <input class="form-control" type="text" name="mes" path="mes"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="referencia">Referencia</label>
                                        <input class="form-control" type="text" name="referencia" path="referencia"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="comentario">Comentario</label>
                                        <input class="form-control" type="text" name="comentario" path="comentario"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="timestamp">Timestamp</label>
                                        <input class="form-control" type="date" name="timestamp" path="timestamp"  />
                                    </div>
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-check fa-fw"></i>Submit</button>
                                    <a href="${appPath}/hora/list" class="btn btn-default"><i class="fa fa-close fa-fw"></i>Cancel</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="/webresources/common/footer.jspf"%>
