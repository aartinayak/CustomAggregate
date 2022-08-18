import java.sql.SQLException;
import java.util.*;
import org.h2.api.AggregateFunction;


public class AggregateFunctionGeoMean implements AggregateFunction
{
    // An array list that holds values of type Float
    ArrayList<Double> values = new ArrayList<>();


    /**
     * This method must return the SQL type of the method, given the SQL type of
     * the input data. The method should check here if the number of parameters
     * passed is correct, and if not it should throw an exception.
     *
     * @param inputTypes the SQL type of the parameters, {@link java.sql.Types}
     * @return the SQL type of the result
     * @throws SQLException on failure
     */

    @Override
    public int getType(int[] inputTypes) throws SQLException
    {
        // TODO Auto-generated method stub
        return java.sql.Types.DOUBLE;
    }

    /**
     * This method is called once for each row.
     * If the aggregate function is called with multiple parameters,
     * those are passed as array.
     *
     * @param value the value(s) for this row
     * @throws SQLException on failure
     */
    @Override
    public void add(Object value) throws SQLException
    {
        // TODO Auto-generated method stub
        values.add((Double) value);
    }

    /**
     * This method returns the computed aggregate value.
     * In our case we are computing the geometric mean for all the values for a column.
     *
     * @return the aggregated value
     * @throws SQLException on failure
     */
    @Override
    public Object getResult() throws SQLException
    {
        // TODO Auto-generated method stub
        double product = 1;
        double gm;
        int power;
        Iterator<Double> itr;
        for (itr = values.iterator(); itr.hasNext();)
        {
            product = product * itr.next();
        }

        power = values.size();

        gm = Math.pow(product, 1.0 / power);

        return gm;
    }

}