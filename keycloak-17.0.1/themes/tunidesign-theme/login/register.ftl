<#import "template.ftl" as layout>
<@layout.registrationLayout displayMessage=!messagesPerField.existsError('firstName','lastName','email','username','password','password-confirm'); section>
    <#if section = "header">
        ${msg("registerTitle")}
    <#elseif section = "form">
        <form id="kc-register-form" class="${properties.kcFormClass!}" action="${url.registrationAction}" method="post">
            <div class="row">
                <div class="col-12">
                    <div class="${properties.kcFormGroupClass!}">
                        <div class="${properties.kcInputWrapperClass!}">
                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" 
                                    id="user.attributes.role" name="user.attributes.role" 
                                    value="${(register.formData['user.attributes.role']!'')}"
                                    aria-invalid="<#if messagesPerField.existsError('user.attributes.role')>true</#if>"
                                />
                                <label class="form-check-label" style="color: white;">${msg("user")}</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" 
                                    id="user.attributes.role" name="user.attributes.role" 
                                    value="${(register.formData['user.attributes.role']!'')}"
                                    aria-invalid="<#if messagesPerField.existsError('user.attributes.role')>true</#if>"
                                />
                                <label class="form-check-label" style="color: white;">${msg("insurance")}</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" 
                                    id="user.attributes.role" name="user.attributes.role" 
                                    value="${(register.formData['user.attributes.role']!'')}"
                                    aria-invalid="<#if messagesPerField.existsError('user.attributes.role')>true</#if>"
                                />
                                <label class="form-check-label" style="color: white;">${msg("garagiste")}</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" 
                                    id="user.attributes.role" name="user.attributes.role" 
                                    value="${(register.formData['user.attributes.role']!'')}"
                                    aria-invalid="<#if messagesPerField.existsError('user.attributes.role')>true</#if>"
                                />
                                <label class="form-check-label" style="color: white;">${msg("societeRemorquage")}</label>
                            </div>

                            <#if messagesPerField.existsError('user.attributes.role')>
                                <span id="input-error-role" class="${properties.kcInputErrorMessageClass!}" aria-live="polite">
                                    ${kcSanitize(messagesPerField.get('user.attributes.role'))?no_esc}
                                </span>
                            </#if>
                        </div>
                    </div>
                </div>
                
                <div class="col-12 col-md-6">
                    <div class="${properties.kcFormGroupClass!}">
                        <div class="${properties.kcLabelWrapperClass!}">
                            <label for="firstName" class="${properties.kcLabelClass!}">${msg("firstName")}</label>
                        </div>
                        <div class="${properties.kcInputWrapperClass!}">
                            <input type="text" id="firstName" class="${properties.kcInputClass!}" name="firstName"
                                value="${(register.formData.firstName!'')}"
                                aria-invalid="<#if messagesPerField.existsError('firstName')>true</#if>"
                            />

                            <#if messagesPerField.existsError('firstName')>
                                <span id="input-error-firstname" class="${properties.kcInputErrorMessageClass!}" aria-live="polite">
                                    ${kcSanitize(messagesPerField.get('firstName'))?no_esc}
                                </span>
                            </#if>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-md-6">
                    <div class="${properties.kcFormGroupClass!}">
                        <div class="${properties.kcLabelWrapperClass!}">
                            <label for="lastName" class="${properties.kcLabelClass!}">${msg("lastName")}</label>
                        </div>
                        <div class="${properties.kcInputWrapperClass!}">
                            <input type="text" id="lastName" class="${properties.kcInputClass!}" name="lastName"
                                value="${(register.formData.lastName!'')}"
                                aria-invalid="<#if messagesPerField.existsError('lastName')>true</#if>"
                            />

                            <#if messagesPerField.existsError('lastName')>
                                <span id="input-error-lastname" class="${properties.kcInputErrorMessageClass!}" aria-live="polite">
                                    ${kcSanitize(messagesPerField.get('lastName'))?no_esc}
                                </span>
                            </#if>
                        </div>
                    </div>
                </div>

                <div class="col-12">
                    <div class="${properties.kcFormGroupClass!}">
                        <div class="${properties.kcLabelWrapperClass!}">
                            <label for="email" class="${properties.kcLabelClass!}">${msg("email")}</label>
                        </div>
                        <div class="${properties.kcInputWrapperClass!}">
                            <div class="input-group">
                                    <span class="input-group-text d-flex justify-content-center"><i class="fa fa-envelope"></i></span>
                                    <input type="text" id="email" class="${properties.kcInputClass!} form-control" name="email"
                                        value="${(register.formData.email!'')}" autocomplete="email"
                                        aria-invalid="<#if messagesPerField.existsError('email')>true</#if>"
                                    />
                                </div>
                            

                            <#if messagesPerField.existsError('email')>
                                <span id="input-error-email" class="${properties.kcInputErrorMessageClass!}" aria-live="polite">
                                    ${kcSanitize(messagesPerField.get('email'))?no_esc}
                                </span>
                            </#if>
                        </div>
                    </div>
                </div>

                <div class="col-12">
                    <div class="${properties.kcFormGroupClass!}">
                        <div class="${properties.kcLabelWrapperClass!}">
                            <label for="user.attributes.phone" class="${properties.kcLabelClass!}">${msg("mobile")}</label>
                        </div>
                        <div class="${properties.kcInputWrapperClass!}">
                            <div class="input-group">
                                    <span class="input-group-text d-flex justify-content-center"><i class="fa fa-phone"></i></span>
                                    <input type="number" id="user.attributes.phone" class="${properties.kcInputClass!} form-control" name="user.attributes.phone"
                                        value="${(register.formData.email!'')}" autocomplete="user.attributes.phone"
                                        aria-invalid="<#if messagesPerField.existsError('user.attributes.phone')>true</#if>"
                                    />
                                </div>
                            

                            <#if messagesPerField.existsError('email')>
                                <span id="input-error-phone" class="${properties.kcInputErrorMessageClass!}" aria-live="polite">
                                    ${kcSanitize(messagesPerField.get('user.attributes.phone'))?no_esc}
                                </span>
                            </#if>
                        </div>
                    </div>
                </div>

                <div class="col-12">
                    <div class="${properties.kcFormGroupClass!}">
                        <div class="${properties.kcLabelWrapperClass!}">
                            <label for="user.attributes.birthdate" class="${properties.kcLabelClass!}">${msg("birthdate")}</label>
                        </div>
                        <div class="${properties.kcInputWrapperClass!}">
                            <div class="input-group">
                                <input type="date" class="${properties.kcInputClass!} form-control" 
                                    id="user.attributes.birthdate" name="user.attributes.birthdate" 
                                    value="${(register.formData['user.attributes.birthdate']!'')}"
                                    aria-invalid="<#if messagesPerField.existsError('user.attributes.birthdate')>true</#if>"
                                />
                            </div>
                            

                            <#if messagesPerField.existsError('user.attributes.birthdate')>
                                <span id="input-error-birthdate" class="${properties.kcInputErrorMessageClass!}" aria-live="polite">
                                    ${kcSanitize(messagesPerField.get('user.attributes.birthdate'))?no_esc}
                                </span>
                            </#if>
                        </div>
                    </div>
                </div>

                <div class="col-12">
                    <div class="${properties.kcFormGroupClass!}">
                        <div class="${properties.kcLabelWrapperClass!}">
                            <label for="user.attributes.gender" class="${properties.kcLabelClass!}">${msg("gender")}</label>
                        </div>
                        <div class="${properties.kcInputWrapperClass!}">
                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" 
                                    id="user.attributes.gender" name="user.attributes.gender" 
                                    value="${(register.formData['user.attributes.gender']!'')}"
                                    aria-invalid="<#if messagesPerField.existsError('user.attributes.gender')>true</#if>"
                                />
                                <label class="form-check-label" for="{{genre.value}}" style="color: white;">${msg("female")}</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" 
                                    id="user.attributes.gender" name="user.attributes.gender" 
                                    value="${(register.formData['user.attributes.gender']!'')}"
                                    aria-invalid="<#if messagesPerField.existsError('user.attributes.gender')>true</#if>"
                                />
                                <label class="form-check-label" for="{{genre.value}}" style="color: white;">${msg("male")}</label>
                            </div>

                            <#if messagesPerField.existsError('user.attributes.gender')>
                                <span id="input-error-gender" class="${properties.kcInputErrorMessageClass!}" aria-live="polite">
                                    ${kcSanitize(messagesPerField.get('user.attributes.gender'))?no_esc}
                                </span>
                            </#if>
                        </div>
                    </div>
                </div>


                <div class="col-12">
                    <#if !realm.registrationEmailAsUsername>
                        <div class="${properties.kcFormGroupClass!}">
                            <div class="${properties.kcLabelWrapperClass!}">
                                <label for="username" class="${properties.kcLabelClass!}">${msg("username")}</label>
                            </div>
                            <div class="${properties.kcInputWrapperClass!}">
                                <input type="text" id="username" class="${properties.kcInputClass!}" name="username"
                                    value="${(register.formData.username!'')}" autocomplete="username"
                                    aria-invalid="<#if messagesPerField.existsError('username')>true</#if>"
                                />

                                <#if messagesPerField.existsError('username')>
                                    <span id="input-error-username" class="${properties.kcInputErrorMessageClass!}" aria-live="polite">
                                        ${kcSanitize(messagesPerField.get('username'))?no_esc}
                                    </span>
                                </#if>
                            </div>
                        </div>
                    </#if>
                </div>

                <#if passwordRequired??>
                    <div class="col-12">
                        <div class="${properties.kcFormGroupClass!}">
                            <div class="${properties.kcLabelWrapperClass!}">
                                <label for="password" class="${properties.kcLabelClass!}">${msg("password")}</label>
                            </div>
                            <div class="${properties.kcInputWrapperClass!}">
                                <div class="input-group">
                                    <span class="input-group-text d-flex justify-content-center"><i class="fa fa-lock"></i></span>
                                    <input type="password" id="password" class="${properties.kcInputClass!} form-control" name="password"
                                        autocomplete="new-password"
                                        aria-invalid="<#if messagesPerField.existsError('password','password-confirm')>true</#if>"
                                    />
                                </div>


                                <#if messagesPerField.existsError('password')>
                                    <span id="input-error-password" class="${properties.kcInputErrorMessageClass!}" aria-live="polite">
                                        ${kcSanitize(messagesPerField.get('password'))?no_esc}
                                    </span>
                                </#if>
                            </div>
                        </div>
                    </div>

                    <div class="col-12">
                        <div class="${properties.kcFormGroupClass!}">
                            <div class="${properties.kcLabelWrapperClass!}">
                                <label for="password-confirm"
                                    class="${properties.kcLabelClass!}">${msg("passwordConfirm")}</label>
                            </div>
                            <div class="${properties.kcInputWrapperClass!}">
                                <div class="input-group">
                                    <span class="input-group-text d-flex justify-content-center"><i class="fa fa-lock"></i></span>
                                    <input type="password" id="password-confirm" class="${properties.kcInputClass!} form-control"
                                        name="password-confirm"
                                        aria-invalid="<#if messagesPerField.existsError('password-confirm')>true</#if>"
                                    />
                                </div>
                                

                                <#if messagesPerField.existsError('password-confirm')>
                                    <span id="input-error-password-confirm" class="${properties.kcInputErrorMessageClass!}" aria-live="polite">
                                        ${kcSanitize(messagesPerField.get('password-confirm'))?no_esc}
                                    </span>
                                </#if>
                            </div>
                        </div>
                    </div>
                </#if>

                <div class="col-12">
                    <#if recaptchaRequired??>
                        <div class="form-group">
                            <div class="${properties.kcInputWrapperClass!}">
                                <div class="g-recaptcha" data-size="compact" data-sitekey="${recaptchaSiteKey}"></div>
                            </div>
                        </div>
                    </#if>
                </div>

                <div class="col-12">
                    <div class="${properties.kcFormGroupClass!}">
                        <div id="kc-form-options" class="${properties.kcFormOptionsClass!}">
                            <div class="${properties.kcFormOptionsWrapperClass!}">
                                <span><a href="${url.loginUrl}">${kcSanitize(msg("backToLogin"))?no_esc}</a></span>
                            </div>
                        </div>

                        <div id="kc-form-buttons" class="${properties.kcFormButtonsClass!}">
                            <input class="${properties.kcButtonClass!} ${properties.kcButtonPrimaryClass!} ${properties.kcButtonBlockClass!} ${properties.kcButtonLargeClass!}" type="submit" value="${msg("doRegister")}"/>
                        </div>
                    </div>
                </div>
            </div>
            
            

            
        </form>
    </#if>
</@layout.registrationLayout>