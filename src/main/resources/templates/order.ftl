<#import "client/templ-client.ftl" as p>
<@p.pages>

    <div class="container py-5">

        <h2 class="mb-4 fw-bold"><i class="bi bi-clipboard-check"></i> Reservation Checkout</h2>

        <div class="row">
            <div class="col-lg-8">

                <div class="card shadow-sm border-0 mb-4">
                    <div class="card-header bg-white py-3">
                        <h5 class="mb-0 fw-bold"><i class="bi bi-person-vcard me-2 text-primary"></i>Your Details</h5>
                    </div>
                    <div class="card-body">
                        <#if user??>
                            <div class="row">
                                <div class="col-sm-4 text-muted small">Full Name</div>
                                <div class="col-sm-8 fw-medium mb-2">${user.firstName} ${user.lastName}</div>

                                <div class="col-sm-4 text-muted small">Phone</div>
                                <div class="col-sm-8 mb-2">${user.phoneNumber}</div>

                                <div class="col-sm-4 text-muted small">Email</div>
                                <div class="col-sm-8">${user.email}</div>
                            </div>
                        </#if>
                    </div>
                </div>

                <div class="card shadow-sm border-0 mb-4 mb-lg-0">
                    <div class="card-header bg-white py-3">
                        <h5 class="mb-0 fw-bold"><i class="bi bi-journal-bookmark me-2 text-primary"></i>Selected Publications</h5>
                    </div>
                    <div class="card-body p-0">
                        <div class="table-responsive">
                            <table class="table table-hover align-middle mb-0">
                                <thead class="bg-light text-muted small">
                                <tr>
                                    <th scope="col" class="ps-4 py-3">Cover</th>
                                    <th scope="col" class="py-3">Title and Author</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#if cart??>
                                    <#list cart.cart as item>
                                        <tr>
                                            <td class="ps-4 py-3" style="width: 80px;">
                                                <img src="${item.publications.image}"
                                                     class="rounded shadow-sm"
                                                     style="width: 50px; height: 75px; object-fit: cover;"
                                                     alt="${item.publications.title}">
                                            </td>
                                            <td class="py-3">
                                                <h6 class="mb-1 fw-bold">${item.publications.title}</h6>
                                                <p class="mb-0 text-muted small">
                                                    <#if item.publications.authors??>
                                                        <#list item.publications.authors as author>
                                                            ${author.firstName} ${author.lastName}<#if author_has_next>, </#if>
                                                        </#list>
                                                    </#if>
                                                </p>
                                            </td>
                                        </tr>
                                    </#list>
                                </#if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>

            <div class="col-lg-4">
                <div class="card shadow-sm border-0 bg-light sticky-top" style="top: 80px;">
                    <div class="card-body p-4">
                        <h4 class="card-title mb-4 fw-bold">Summary</h4>

                        <div class="d-flex justify-content-between mb-4 fs-5">
                            <span class="text-muted">Total books:</span>
                            <span class="fw-bold text-primary">
                                <#if cart.cart??>${cart.getSumItem()}</#if> pcs.
                            </span>
                        </div>

                        <hr class="mb-4">

                        <form action="/buy" method="post">
                            <div class="mb-3">
                                <label for="pick-up" class="form-label fw-medium text-muted small">Pickup Method</label>
                                <select class="form-select" name="pick-up" id="pick-up" required>
                                    <option value="1">Library Pickup (Main Hall)</option>
                                    <option value="2">Reading Room (No taking home)</option>
                                </select>
                            </div>

                            <div class="mb-4">
                                <label for="time" class="form-label fw-medium text-muted small">Reservation Period</label>
                                <select class="form-select" name="time" id="time" required>
                                    <option value="1">For 14 days</option>
                                    <option value="2">For 30 days (Students/Teachers)</option>
                                </select>
                            </div>

                            <button type="submit" class="btn btn-primary w-100 btn-lg fw-bold shadow-sm">
                                <i class="bi bi-check2-circle me-2"></i>Confirm
                            </button>
                        </form>

                    </div>
                </div>
            </div>

        </div>
    </div>

</@p.pages>