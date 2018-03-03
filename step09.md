# @NotFound(action=NotFoundAction.IGNORE)

to suppresses the exception throwsn by any realtion object not available for the object (Example No user for the Vehicel.)

# @OneToMany(cascade = CascadeType.PERSIST)

To persist the child's of particular object automatically without saving the each and every individual objects.


## Inheritance with Hibernate

To implements inheritance functionality. hibernate automatically implements single table stretagy.

### @Inheritance(Strategy=Inheritanace.SINGLE_TABLE)

@DiscriminatorValue("<Object-Name>")

so it will save Each Entity in a with the specified Entity Name with in the Single table.

### @Inheritance(Strategy=Inheritanace.TABLE_PER_CLASS).

so it will create a New Table for Each Class.

### @Inheritance(Strategy=Inheritanace.JOINED).

