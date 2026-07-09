<#import "client/templ-client.ftl" as p>
<#import "/spring.ftl" as s>
<@p.pages>

    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">

                <div class="card shadow-lg border-0 rounded-4">
                    <div class="card-body p-4 p-sm-5">

                        <div class="text-center mb-4">
                            <div class="bg-success bg-opacity-10 text-success rounded-circle d-inline-flex align-items-center justify-content-center mb-3" style="width: 60px; height: 60px;">
                                <i class="bi bi-person-lines-fill fs-2"></i>
                            </div>
                            <h3 class="fw-bold">Registration</h3>
                            <p class="text-muted small">Create a new account</p>
                        </div>

                        <#if message?? && message != " ">
                            <div class="alert alert-warning d-flex align-items-center small" role="alert">
                                <i class="bi bi-info-circle-fill me-2"></i>
                                <div>${message}</div>
                            </div>
                        </#if>

                        <@s.bind "users"/>

                        <form method="post" action="/registration">

                            <h6 class="text-uppercase text-muted small fw-bold mb-3">Account Credentials</h6>

                            <div class="form-floating mb-3">
                                <@s.formInput "users.username" "class='form-control' placeholder='Username' required"/>
                                <label for="users.username">Username</label>
                                <div class="text-danger small"><@s.showErrors "<br>"/></div>
                            </div>

                            <div class="form-floating mb-4">
                                <@s.formInput "users.password" "class='form-control' placeholder='Password' type='password' required"/>
                                <label for="users.password">Password</label>
                                <div class="text-danger small"><@s.showErrors "<br>"/></div>
                            </div>

                            <h6 class="text-uppercase text-muted small fw-bold mb-3 border-top pt-3">Personal Information</h6>

                            <div class="row g-2 mb-3">
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <@s.formInput "users.firstName" "class='form-control' placeholder='First Name' required"/>
                                        <label>First Name</label>
                                        <div class="text-danger small"><@s.showErrors "<br>"/></div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <@s.formInput "users.lastName" "class='form-control' placeholder='Last Name' required"/>
                                        <label>Last Name</label>
                                        <div class="text-danger small"><@s.showErrors "<br>"/></div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-floating mb-3">
                                <@s.formInput "users.email" "class='form-control' placeholder='Email' type='email' required"/>
                                <label>Email</label>
                                <div class="text-danger small"><@s.showErrors "<br>"/></div>
                            </div>

                            <div class="row g-2 mb-4">
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <@s.formInput "users.phoneNumber" "class='form-control' placeholder='Phone' type='tel'"/>
                                        <label>Phone</label>
                                        <div class="text-danger small"><@s.showErrors "<br>"/></div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" placeholder="Date of Birth">
                                        <label for="dateOfBirth">Date of Birth</label>
                                        <div class="text-danger small">
                                            <@s.showErrors "<br>"/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="d-grid">
                                <button class="btn btn-success btn-lg fw-bold" type="submit">Register</button>
                            </div>

                        </form>

                        <div class="text-center mt-4">
                            <p class="mb-0 text-muted small">Already have an account?</p>
                            <a href="/login" class="text-decoration-none fw-bold text-success">Login</a>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>

</@p.pages>