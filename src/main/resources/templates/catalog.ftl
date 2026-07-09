<#import "client/templ-client.ftl" as p>

<@p.pages>
    <aside class="col-lg-3 mb-4">

        <div class="card shadow-sm mb-4">
            <div class="card-header bg-white fw-bold">
                <i class="bi bi-list-ul"></i> Categories
            </div>
            <ul class="list-group list-group-flush">
                <a href="/catalog" class="list-group-item list-group-item-action <#if !activeCategory?? && !activeGenre??>active</#if>">
                    All Books
                </a>

                <#if categories??>
                    <#list categories as cat>
                        <a href="/catalog/category/${cat.id}"
                           class="list-group-item list-group-item-action d-flex justify-content-between align-items-center <#if activeCategory?? && activeCategory.id == cat.id>active</#if>">

                            ${cat.name}

                            <span class="badge <#if activeCategory?? && activeCategory.id == cat.id>bg-light text-primary<#else>bg-primary</#if> rounded-pill">
                                <#if cat.publications??>${cat.publications?size}<#else>0</#if>
                            </span>
                        </a>
                    </#list>
                </#if>
            </ul>
        </div>

        <div class="card shadow-sm">
            <div class="card-header bg-white fw-bold">
                <i class="bi bi-tags"></i> Genres
            </div>
            <div class="card-body">
                <#if genres??>
                    <#list genres as genre>
                        <a href="/catalog/genre/${genre.id}"
                           class="badge <#if activeGenre?? && activeGenre.id == genre.id>bg-primary<#else>bg-secondary</#if> text-decoration-none p-2 mb-1">
                            ${genre.name}
                        </a>
                    </#list>
                </#if>
            </div>
        </div>
    </aside>

    <main class="col-lg-9">

        <div class="d-flex justify-content-between align-items-center mb-3 pb-2 border-bottom">

            <h2 class="h4 mb-0">
                <#if activeCategory??>
                    Category: <span class="text-primary">${activeCategory.name}</span>
                <#elseif activeGenre??>
                    Genre: <span class="text-primary">${activeGenre.name}</span>
                <#else>
                    All Publications
                </#if>
            </h2>

            <#if activeCategory?? || activeGenre??>
                <a href="/catalog" class="btn btn-sm btn-outline-secondary ms-2">
                    <i class="bi bi-x-circle"></i> Show All
                </a>
            </#if>

            <nav aria-label="breadcrumb" class="ms-auto">
                <ol class="breadcrumb mb-0">
                    <li class="breadcrumb-item"><a href="/">Home</a></li>
                    <li class="breadcrumb-item"><a href="/catalog">Catalog</a></li>

                    <#if activeCategory??>
                        <li class="breadcrumb-item active" aria-current="page">${activeCategory.name}</li>
                    <#elseif activeGenre??>
                        <li class="breadcrumb-item active" aria-current="page">${activeGenre.name}</li>
                    </#if>
                </ol>
            </nav>
        </div>

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-4">
            <#if publications??>
                <#list publications as publication>
                    <div class="col">
                        <div class="card h-100 shadow-sm book-card border-0">

                            <div style="height: 250px; overflow: hidden;" class="position-relative">
                                <img src="/${publication.image}"
                                     class="card-img-top h-100 w-100" style="object-fit: cover;" alt="${publication.title}">

                                <span class="position-absolute top-0 end-0 badge bg-primary m-2 shadow">
                                    ${(publication.category.name)!'Book'}
                                </span>
                            </div>

                            <div class="card-body d-flex flex-column">
                                <h5 class="card-title text-truncate" title="${publication.title}">${publication.title}</h5>

                                <h6 class="card-subtitle mb-2 text-muted small">
                                    <#if publication.authors??>
                                        <#list publication.authors as author>
                                            ${author.firstName} ${author.lastName}<#if author_has_next>, </#if>
                                        </#list>
                                    </#if>
                                </h6>

                                <p class="card-text text-muted small card-text-clamp flex-grow-1">
                                    ${publication.summary!'No description available...'}
                                </p>

                                <div class="mt-2 d-flex justify-content-between align-items-center">
                                    <#if publication.isAvailable>
                                        <span class="badge bg-success bg-opacity-10 text-success border border-success">
                                            <i class="bi bi-check-circle"></i> In Stock
                                        </span>
                                    <#else>
                                        <span class="badge bg-secondary bg-opacity-10 text-secondary border border-secondary">
                                            <i class="bi bi-x-circle"></i> Out of Stock
                                        </span>
                                    </#if>
                                </div>
                            </div>

                            <div class="card-footer bg-white border-top-0 pt-0 pb-3">
                                <div class="d-grid gap-2">
                                    <form action="/addPublicationToCart" method="post" class="d-grid">
                                        <input type="hidden" name="id" value="${publication.id}">
                                        <button type="submit" class="btn btn-primary btn-sm" <#if !publication.instances?? || !publication.isAvailable>disabled</#if>>
                                            <i class="bi bi-journal-plus"></i> Reserve
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
            <#else>
                <div class="col-12 text-center py-5">
                    <div class="text-muted mb-3">
                        <i class="bi bi-journal-x display-1"></i>
                    </div>

                    <h4>
                        <#if activeCategory??>
                            In this category
                        <#elseif activeGenre??>
                            In this genre
                        <#else>
                            For your request
                        </#if>
                        there are no books yet
                    </h4>

                    <p class="text-muted">Try choosing something else or come back later.</p>
                    <a href="/catalog" class="btn btn-outline-primary">Show all books</a>
                </div>
            </#if>
        </div>
    </main>

</@p.pages>