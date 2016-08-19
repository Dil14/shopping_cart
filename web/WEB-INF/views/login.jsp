<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">

    <div class="container">

        <div class="login-box">

            <h2>Login with Username and Password</h2>


                <c:if test="${not empty msg}">
            <div class="msg" style="color: greenyellow;font-family: 'Lucida Console'">${msg}</div>
                </c:if>


            <form name="loginForm" action="<c:url value="/j_spring_security_check"/>" method="post">



                <div class="form-group">
                                    <label for="username">UserName</label>
                <input type="text" name="username" id="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                <input type="password" name="password" id="password" class="form-control"/>
                </div>


            <c:if test="${not empty error}">
                <div class="error" style="color:red;font-family: 'Lucida Console'">${error}</div>
                <br/>
                <br/>
            </c:if>


            <input type="submit" value="Login" class="btn btn-default"/>

                <input type="reset" value="Cancel" class="btn btn-default"/>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            </form>

        </div>

    </div>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>