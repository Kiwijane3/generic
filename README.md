kiwijane3.generic: By Jane Fraser

I developed these classes for my own personal use, but I felt they could be useful to other. There are several classes,
which do various things. This is a brief overview:

There are some functional interfaces in the package functional interfaces. These exist to get around the standard functional
interfaces being unable to be called on API level 23 and older.

Event, a class for Event-based programming. This uses the Action class from functionalinterfaces.

A base class for ViewControllers, which simplifies filling a viewgroup with contents, and a ViewHolder base class for using
these ViewControllers with RecyclerView.

Two AsyncTasks, one for loading web images, and another that uses functions to allow customization.

A selection, a data structure which is essentially an immutable list of strings that can be selected and deselected.

Finally, there is a Conversion class with some basic conversions.