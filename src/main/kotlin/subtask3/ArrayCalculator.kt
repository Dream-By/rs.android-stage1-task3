package subtask3

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val itemslist = mutableListOf<Int>()

        for(item in itemsFromArray)
            if(item is Int)
                itemslist.add(item)

        if(itemslist.isEmpty())
            return 0

        if(numberOfItems >= itemslist.size){
            var product = 1
            for(item in itemslist)
                product*=item
            return product
        }

        itemslist.sortDescending()

        var product = 1

        if(numberOfItems % 2 == 1){
            product*=itemslist.first()
            itemslist.removeAt(0)
        }

        val pairsProduct = mutableListOf<Int>()
        for(itemIndex in itemslist.indices){
            if(itemIndex+1 != itemslist.size)
                pairsProduct.add(itemslist[itemIndex] * itemslist[itemIndex+1])
        }

        pairsProduct.sortDescending()

        for(i in 1..numberOfItems/2)
            product*=pairsProduct[i-1]

        return product
    }
}
