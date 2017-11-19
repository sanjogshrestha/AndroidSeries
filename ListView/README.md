# ListView

Android ListView is a view which groups several items and display them in vertical scrollable list. The list items are automatically inserted to the list using an Adapter that pulls content from a source such as an array or database.

An adapter actually bridges between UI components and the data source that fill data into UI Component. Adapter holds the data and send the data to adapter view, the view can takes the data from adapter view and shows the data on different views like as spinner, list view, grid view etc.

<img src="https://github.com/sanjogshrestha/AndroidSeries/blob/master/ListView/screenshot/adapter.png">

##Simple Implementation from XML

Here we create ListView in XML layout file.
To load the entries we use android:entries attribute on list view element which points to the <string-array> defined by external resource in res/values/strings.xml.

Instead of loading the entries programatically using adapters (more specifically ArrayAdapter or CursorAdaptor) we have used XML layout file.

This approach is good, if your list items are simple string values (TextView).

Here, we are going to implement OnItemClickListener event listener which calls onItemClick() callback method where we retrieve and display the item selected by the user.

<img src="https://github.com/sanjogshrestha/AndroidSeries/blob/master/ListView/screenshot/1.png" 
width="350" height="600">

###Array Adapter

The ArrayAdapter class can handle a list or arrays of Java objects as input. Every Java object is mapped to one row. By default, it maps the toString() method of the object to a view in the row layout.

You can define the ID of the view in the constructor of the ArrayAdapter otherwise the android.R.id.text1 ID is used as default.

The ArrayAdapter class allows to remove all elements in its underlying data structure with the clear() method call. You can then add new elements via the add() method or a Collection via the addAll() method.

You can also directly modify the underlying data structure and call the notifyDataSetChanged() method on the adapter to notify it about the changes in data.

<img src="https://github.com/sanjogshrestha/AndroidSeries/blob/master/ListView/screenshot/2.png" 
width="350" height="600">

####Custom Adapter
The ArrayAdapter is limited as it supports only the mapping of toString() to one view in the row layout. To control the data assignment and to support several views, you have to create your custom adapter implementation.

For this you would extend an existing adapter implementation or subclass the BaseAdapter class directly.

<img src="https://github.com/sanjogshrestha/AndroidSeries/blob/master/ListView/screenshot/3.png" 
width="350" height="600">