<#import "client/templ-client.ftl" as p>
<@p.pages>

    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">

                <div class="card shadow-lg border-0 rounded-4">
                    <div class="card-body p-4 p-sm-5">

                        <div class="text-center mb-4">
                            <div class="bg-primary bg-opacity-10 text-primary rounded-circle d-inline-flex align-items-center justify-content-center mb-3" style="width: 60px; height: 60px;">
                                <i class="bi bi-box-arrow-in-right fs-2"></i>
                            </div>
                            <h3 class="fw-bold">Login</h3>
                            <p class="text-muted small">Access the library system</p>
                        </div>

                        <#if RequestParameters.error??>
                            <div class="alert alert-danger d-flex align-items-center small" role="alert">
                                <i class="bi bi-exclamation-circle-fill me-2"></i>
                                <div>Invalid username or password</div>
                            </div>
                        </#if>

                        <#if RequestParameters.logout??>
                            <div class="alert alert-success d-flex align-items-center small" role="alert">
                                <i class="bi bi-check-circle-fill me-2"></i>
                                <div>You have successfully logged out</div>
                            </div>
                        </#if>

                        <form method="post" action="/login">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="username" name="username" placeholder="name" required autofocus>
                                <label for="username">Username</label>
                            </div>

                            <div class="form-floating mb-4">
                                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                                <label for="password">Password</label>
                            </div>

                            <div class="d-grid gap-2">
                                <button class="btn btn-primary btn-lg fw-bold" type="submit">Login</button>
                            </div>
                        </form>

                        <div class="text-center mt-4">
                            <p class="mb-0 text-muted small">Don't have an account yet?</p>
                            <a href="/registration" class="text-decoration-none fw-bold">Register Now</a>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>

</@p.pages>