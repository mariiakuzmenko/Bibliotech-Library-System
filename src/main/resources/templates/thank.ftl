<#import "client/templ-client.ftl" as p>
<@p.pages>

    <div class="container py-5">
        <div class="row justify-content-center text-center">
            <div class="col-md-8 col-lg-6">

                <div class="card shadow-lg border-0 rounded-4 p-4 p-sm-5 mt-4">

                    <div class="text-success mb-4">
                        <i class="bi bi-check-circle-fill" style="font-size: 5rem;"></i>
                    </div>

                    <h1 class="fw-bold mb-3 text-dark">Reservation Successful!</h1>

                    <p class="lead text-muted mb-4">
                        <#if info?? && info != " ">
                            ${info}
                        <#else>
                            Your books have been successfully reserved. We look forward to seeing you at the library!
                        </#if>
                    </p>

                    <#if id_order?? && id_order != " ">
                        <div class="bg-light rounded-3 py-3 px-4 mb-4 d-inline-block">
                            <span class="text-muted me-2">Your reservation number:</span>
                            <span class="fw-bold fs-5 text-primary">#${id_order}</span>
                        </div>
                    </#if>

                    <hr class="my-4 text-muted">

                    <div class="d-grid gap-3 d-sm-flex justify-content-sm-center">
                        <a href="/catalog" class="btn btn-outline-secondary btn-lg px-4 rounded-pill">
                            <i class="bi bi-book me-2"></i> Back to Catalog
                        </a>
                    </div>

                </div>

            </div>
        </div>
    </div>

</@p.pages>