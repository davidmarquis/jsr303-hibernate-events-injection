This small project demonstrates how to configure Spring's bean injection with Hibernate event-based
validation.

The reference [Hibernate Validator documentation](http://docs.jboss.org/hibernate/stable/validator/reference/en-US/html/validator-checkconstraints.html#validator-checkconstraints-orm-hibernateevent)
states that it is possible to configure Hibernate to validate beans before three events:
1. Before saving (pre-insert)
1. Before updating (pre-update)
1. Before deleting (pre-update)

Although this is convenient for simple validators, more complex custom validators might require that you
inject references to beans managed by your Spring context. The example presented in Hibernate Validator's
documentation doesn't mention this possibility, and doing so must not be immediately obvious.

This project defines a custom validator (`com.github.davidmarquis.model.validation.CustomValidationValidator`) that
has an `@Autowired` bean injected. The User model (`com.github.davidmarquis.model.User`) uses this custom validation rule on the `email` field.
Everything is wrapped up together in `src/main/resources/applicationContext.xml`.

Run `maven test` in the project root to see this in action.
