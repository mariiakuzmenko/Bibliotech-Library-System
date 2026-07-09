<#import "client/templ-client.ftl" as p>
<@p.pages>

    <div class="container py-5">

        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="mb-0 fw-bold"><i class="bi bi-cart3"></i> Your Reservation Cart</h1>

            <#if RequestParameters.error??>
                <div class="alert alert-danger d-flex align-items-center mb-4" role="alert">
                    <i class="bi bi-exclamation-triangle-fill me-2"></i>
                    <div>${RequestParameters.error}</div>
                </div>
            </#if>

            <#if cart.cart??>
                <form action="/removeAllReservationsInCart" method="post" class="m-0">
                    <button type="submit" class="btn btn-outline-danger" onclick="return confirm('Are you sure you want to remove all books from the cart?');">
                        <i class="bi bi-trash3"></i> Clear Cart
                    </button>
                </form>
            </#if>
        </div>

        <#if cart??>

            <div class="row">
                <div class="col-lg-8">
                    <div class="card shadow-sm border-0">
                        <div class="card-body p-0">
                            <table class="table table-hover align-middle mb-0">
                                <thead class="bg-light">
                                <tr>
                                    <th scope="col" class="py-3 ps-4">Publication</th>
                                    <th scope="col" class="py-3 text-end pe-4">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list cart.cart as item>
                                    <tr>
                                        <td class="ps-4 py-3">
                                            <div class="d-flex align-items-center">
                                                <div class="flex-shrink-0">
                                                    <img src="${item.publications.image}"
                                                         class="rounded border"
                                                         style="width: 60px; height: 90px; object-fit: cover;"
                                                         alt="${item.publications.title}">
                                                </div>

                                                <div class="flex-grow-1 ms-3">
                                                    <h5 class="text-decoration-none text-dark">
                                                            ${item.publications.title}
                                                    </h5>
                                                    <p class="mb-0 text-muted small">
                                                        <#if item.publications.authors??>
                                                            <#list item.publications.authors as author>
                                                                ${author.firstName} ${author.lastName}<#if author_has_next>, </#if>
                                                            </#list>
                                                        </#if>
                                                    </p>
                                                </div>
                                            </div>
                                        </td>

                                        <td class="text-end pe-4">
                                            <form action="/deleteFromCart" method="post">
                                                <input type="hidden" name="id" value="${item.publications.id}">
                                                <button type="submit" class="btn btn-outline-danger btn-sm">
                                                    <i class="bi bi-trash"></i>
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 mt-4 mt-lg-0">
                    <div class="card shadow-sm border-0 bg-light">
                        <div class="card-body p-4">
                            <h4 class="card-title mb-3">Summary</h4>
                            <div class="d-flex justify-content-between mb-3">
                                <span>Books in cart:</span>
                                <span class="fw-bold">${cart.getSumItem()}</span>
                            </div>
                            <hr>

                            <form action="/order" method="get">
                                <button type="submit" class="btn btn-primary w-100 py-2 fs-5">
                                    Confirm Reservation
                                </button>
                            </form>

                            <div class="mt-3 text-center">
                                <a href="/catalog" class="text-decoration-none">Continue Browsing</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        <#else>
            <div class="text-center py-5 bg-light rounded-3">
                <i class="bi bi-basket3 display-1 text-muted mb-3"></i>
                <h3>Cart is empty</h3>
                <p class="text-muted">You haven't added anything to your reservation yet.</p>
                <a href="/catalog" class="btn btn-primary mt-2">Go to Catalog</a>
            </div>
        </#if>

    </div>

</@p.pages>