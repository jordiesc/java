<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webresources/common/header.jspf"%>

<div id="wrapper">
    <%@ include file="/webresources/common/navigationbar.jspf"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5><i class="fa fa-edit fa-fw"></i> <b> Update Hora</b></h5> 
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="${appPath}/hora/update" method="POST">
                                    <input type="hidden" name="id" value="${HORA.id}" />
                                    <div class="form-group">
                                        <label for="hora">Hora</label>
                                        <input class="form-control" type="number" name="hora"  value="${HORA.hora}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="mes">Mes</label>
                                        <input class="form-control" type="text" name="mes"  value="${HORA.mes}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="referencia">Referencia</label>
                                        <input class="form-control" type="text" name="referencia"  value="${HORA.referencia}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="comentario">Comentario</label>
                                        <input class="form-control" type="text" name="comentario"  value="${HORA.comentario}" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="timestamp">Timestamp</label>
                                        <input class="form-control" type="date" name="timestamp"  value="${HORA.timestamp}" />
                                    </div>     
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-check fa-fw"></i>Update</button>
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
