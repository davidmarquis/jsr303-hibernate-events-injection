This small project demonstrates how to configure Spring's bean injection with Hibernate event-based
validation.

The reference [Hibernate Validator documentation](http://docs.jboss.org/hibernate/stable/validator/reference/en-US/html/validator-checkconstraints.html#validator-checkconstraints-orm-hibernateevent)
states that it is possible to configure Hibernate to validate beans before three events:

* Before saving (pre-insert)
* Before updating (pre-update)
* Before deleting (pre-update)

Although this is convenient for simple validators, more complex custom validators might require that you
inject references to beans managed by your Spring context. The example presented in Hibernate Validator's
documentation doesn't mention this possibility. Although it is possible to do it, the exact way may not be immediately obvious.

This project defines:

* A custom validator (`com.github.davidmarquis.model.validation.CustomValidationValidator`) that
has an `@Autowired` bean injected.
* A User model (`com.github.davidmarquis.model.User`) that uses this custom validation rule on the `email` field.
* A JUnit test case that simply tries to save a User instance on a new Hibernate session. This triggers Hibernate's pre-insert event which, in turn, instantiates and triggers our custom validator, with autowired dependencies injected. Great success!
* Everything is wrapped up together in `src/main/resources/applicationContext.xml`.

Run `maven test` in the project root to see this in action.
