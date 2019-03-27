// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package clusterleader.actions;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

public class InitializeInstance extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String ScheduledEventMicroflow;

	public InitializeInstance(IContext context, java.lang.String ScheduledEventMicroflow)
	{
		super(context);
		this.ScheduledEventMicroflow = ScheduledEventMicroflow;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		Core.getLogger(this.toString()).info("Scheduling " + this.ScheduledEventMicroflow + " every 5 minutes, starting now");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 6);
		
		Core.scheduleAtFixedRate(this.ScheduledEventMicroflow, cal.getTime(), 5, TimeUnit.MINUTES, "SchedulerMaintenance", 
				"This action runs every 5 minutes and evaluates and cleans up all action information");
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "InitializeInstance";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
