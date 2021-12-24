package Default;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MAIN {
	
	public static final String MENU_MAIN_STRING       = "|                         MAIN MENU                           |";
	public static final String MENU_SORT_STRING       = "|                         SORT MENU                           |";
	public static final String MENU_FILTER_STRING     = "|                        FILTER MENU                          |";
	public static final String MENU_MERGEFILES_STRING = "|                      MERGE FILES MENU                       |";
	public static final String MENU_READ_STRING       = "|                       READ FILES MENU                       |";
	
	public static Scanner scanner;
	static int chooserMenus = 0;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		
		//setupMainMenu(MENU_MAIN_STRING);
		setupMenuDisplay(MENU_MAIN_STRING);
		
		/*
		setupMainMenu(MENU_SORT_STRING);
		
		setupMainMenu(MENU_FILTER_STRING);
		
		setupMainMenu(MENU_MERGEFILES_STRING);
		*/
		

	}
	
	public static void setupMenuDisplay(String menuType) {
		
		if(MENU_MAIN_STRING.equals(menuType)) {
			intiateMainMenuChoose(menuType);
		}else if(MENU_SORT_STRING.equals(menuType)) {
			intiateSortMenuChoose(menuType);
		}else if(MENU_FILTER_STRING.equals(menuType)) {
			intiateFilterMenuChoose(menuType);
		}else if(MENU_MERGEFILES_STRING.equals(menuType)) {
			intiateMergeMenuChoose(menuType);
		}else if(MENU_READ_STRING.equals(menuType)) {
			intiateReadMenuChoose(menuType);
		}else {
			//intiateMainMenuChoose(menuType);
			System.out.println(" ERROR! INVALID COMMAND! EXITING APPLICATION");
		}
		
		
		
	}
	
	/*
	 * Does the actual sorting with regard to choose 
	 * */
	public static void setupAnyMenu(String MenuString) {
		//top two rows of menu
		System.out.println("###############################################################");
		System.out.println("|                                                             |");
				
		//middle part of menu
		System.out.println(MenuString);
				
		//bottom two rows of menu
		System.out.println("|                                                             |");
		System.out.println("###############################################################");
		System.out.println("\n");
	}

	//main menu chooser
	public static void intiateMainMenuChoose(String menuType) {
		
		boolean ifClose = false;
		
		while(!ifClose) {
			
			String finalizer = " ";
			
			setupAnyMenu(menuType);
			
			System.out.println("Choose an operation to proceed e.g 1 or 2");
			System.out.println(" 1. Read from files");
			System.out.println(" 2. Sort files");
			System.out.println(" 3. Merge data in files");
			System.out.println(" 4. Filter files");
			System.out.println(" 5. Exit");
			
			chooserMenus = scanner.nextInt();

			switch (chooserMenus) {
				case 1 -> {
					//System.out.println("Reading from files.....Wait!");
					setupMenuDisplay(MENU_READ_STRING);
				}

				//System.out.println("Press any key to exit to main menu");
				//scanner.nextLine();
				//ifClose = true;
				case 2 -> {
					System.out.println(" ");
					setupMenuDisplay(MENU_SORT_STRING);
				}
				case 3 ->
						//System.out.println("Merge data from files.....Wait!");

						setupMenuDisplay(MENU_MERGEFILES_STRING);


				//System.out.println("Press any key to exit to main menu");
				//finalizer = scanner.nextLine();
				//ifClose = true;
				case 4 ->
						//System.out.println("Filter files.....Wait!");

						setupMenuDisplay(MENU_FILTER_STRING);


				//ifClose = true;
				case 5 -> {
					System.out.println("BYE!");
					ifClose = true;
				}
				default -> System.out.println("No such operation defined! Try again.");
			}
				
		}
		
	}
	
	/*
	 * Does the layout of the read files menu for one to choose 
	 * */
	public static void intiateReadMenuChoose(String menuType) {
		
		boolean ifClose = false;
		
		while(!ifClose) {
			
			setupAnyMenu(menuType);
			
			System.out.println("Choose file type to proceed e.g 1 or 2");
			System.out.println(" 1. Read from txt file");
			System.out.println(" 2. Read from csv file");
			
			System.out.println(" 5. Back to Main Menu");
			
			int chooserMenus = scanner.nextInt();
			
			System.out.println("File contains data from FIFA worldcup");
			switch (chooserMenus) {
				case 1 -> {
					System.out.println("Reading text file.....Wait! \n");

					//:TODO read text file
					try {
						File file = new File("/Users/navjotbedi/Desktop/Project2Fall/Project2Fall/src/Default/Data Files/fifaCountries.txt");

						if (null != file && file.exists()) {
							readFromFile(file, false);
						}

					} catch (Exception e) {
						System.out.println("Exception = " + e.getMessage());
						e.printStackTrace();
					}
				}

				//ifClose = true;
				case 2 -> {
					System.out.println("Reading csv file.....Wait! \n");

					//:TODO read csv file
					try {
						File filecsv = new File("/Users/navjotbedi/Desktop/Project2Fall/Project2Fall/src/Default/Data Files/fifaCountries.csv");
						if (null != filecsv && filecsv.exists()) {
							readFromFile(filecsv, true);
						}

					} catch (Exception e) {
						System.out.println("Exception = " + e.getMessage());
						e.printStackTrace();
					}
				}


				//ifClose = true;
				case 5 -> {
					//exit
					System.out.println("\n\n");
					//go back to main menu
					setupMenuDisplay(MENU_MAIN_STRING);
					ifClose = true;
				}
				default -> {
					System.out.println("No such operation defined! Try again.");
					System.out.println("\n");
				}

				//TreeMap<Integer,Country> treeMap = new TreeMap<>();

			}
			
		}
		
		
	}
	
	/*
	 * Does the actual reading of files with regard to choose and if csv 
	 * */
	public static void readFromFile(File file,boolean isCSV) {
		try {
			
			Scanner scan = new Scanner(file);
			isCSV = true;
			
			if(isCSV) {
				
				scan.useDelimiter(",|\\n");
				
				String column1 = scan.next();
				String column2 = scan.next();
				String column3 = scan.next();
				String column4 = scan.next();
				String column5 = scan.next();
				
				System.out.printf("%-20s %15s %17s %18s %20s\n",column1,column2,column3,column4,column5);
				
				while(scan.hasNext()) {
					
					String country = scan.next();
					String confederation = scan.next();
					String population_share = scan.next();
					String tv_audience_share = scan.next();
					String gdp_weighted_share = scan.next();
					
					System.out.printf("%-20s %15s %17s %18s %20s\n",
							country,
							confederation,
							population_share,
							tv_audience_share,
							gdp_weighted_share);
					
				}
				
				System.out.println("\n ######## END OF FILE ######## \n");
			}else {
				
				
			}
			
			scan.close();
			
		}catch(Exception e) {
			System.out.println("Exception = "+e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
	
	/*
	 * Does the layout menu of sort menu 
	 * */
	public static void intiateSortMenuChoose(String menuType) {
		int choosing = 0;
		boolean ifClose = false;
		
		while(!ifClose) {
			
			setupAnyMenu(menuType);
			
			System.out.println("\n");
			System.out.println("Choose file type to proceed e.g 1 or 2");
			System.out.println(" 1. Sort from txt file");
			System.out.println(" 2. Sort from csv file");
			
			System.out.println(" 6. Back to Main Menu");
			
			choosing = scanner.nextInt();
			
			if(6==choosing) {
				//System.out.println("BYE!");
				ifClose = true;
			}else if(2==choosing || 1==choosing) {
				
				System.out.println(" \n");
				System.out.println("Choose sort criteria to proceed e.g 1 or 2");
				System.out.println(" 1. Sort countries in descending Country Name order");
				System.out.println(" 2. Sort countries in descending TV Audience Shares order");
				System.out.println(" 3. Sort according to Population Share");
				
				//System.out.println(" 7. Back to Main Menu");
				
				int chooserMenus = scanner.nextInt();
				
				if(1==chooserMenus || 2==chooserMenus || 3==chooserMenus) {
					executeSort(chooserMenus);
					ifClose=true;
				}else {
					System.out.println("Invalid choice!");
				}
				
			}else {
				System.out.println("Invalid command. Select again!");
				
			}
			
			
		}
		
		
		
	}
	
	/*
	 * Does the actual sorting with regard to choose 
	 * */
	public static void executeSort(int choose) {
		
		TreeMap<String,Country> myMapTree = new TreeMap<>();
		//Map<String,Country> myCountryMap = new HashMap<>();
		
		//myMapTree.putAll(myCountryMap);
		
		boolean isExecuteSort = true;
		//File fileOut = null;
		
		File file = new File("/Users/anmolk/Desktop/Project2Fall/Project2Fall/src/Default/Data Files/fifaCountries.txt");
		
		
		if(isExecuteSort) {
			
			try {
				/*if(!fileOut.exists()) {
					fileOut.mkdirs();
				}*/
				
				Scanner scan = new Scanner(file);
				//PrintWriter writer = new PrintWriter(fileOut);
				boolean isCSV = true;
				
				
				if(isCSV) {
					
					scan.useDelimiter(",|\\n");
					
					String column1 = scan.next();
					String column2 = scan.next();
					String column3 = scan.next();
					String column4 = scan.next();
					String column5 = scan.next();
					
					System.out.printf("%-20s %15s %17s %18s %20s\n",column1,column2,column3,column4,column5);
					
					while(scan.hasNext()) {
						
						String country = scan.next();
						String confederation = scan.next();
						String population_share = scan.next();
						String tv_audience_share = scan.next();
						String gdp_weighted_share = scan.next();
						
						Country countryClass = new Country(country,confederation,population_share,tv_audience_share,gdp_weighted_share);
						
						//put values to country class
						if(3==choose) {
							myMapTree.put(population_share,countryClass);
						}else if(2==choose) {
							myMapTree.put(tv_audience_share,countryClass);
						}else {
							myMapTree.put(country,countryClass);
						}
						
						
					}
					
					
					for(String key:myMapTree.keySet()) {
						
						Country country1 = myMapTree.get(key);
						
						System.out.printf("%-20s %15s %17s %18s %20s\n",
								country1.country,
								country1.confederation,
								country1.population_share,
								country1.tv_audience_share,
								country1.gdp_weighted_share);
								
					}
					
					System.out.println("\n ######## END OF FILE ######## \n");
					
					myMapTree.clear();
				}else {
					
					
				}
				
				scan.close();
				
			}catch(Exception e) {
				System.out.println("Exception = "+e.getMessage());
				e.printStackTrace();
			}
			
			
			
		}else {
			
			
			
		}
		
	}

	/*
	 * Does the layout of filter menu 
	 * */
	public static void intiateFilterMenuChoose(String menuType) {
		
		boolean ifClose = false;
		TreeMap<String,Country> myMapTree = new TreeMap<>();
		
		while(!ifClose) {
			
			setupAnyMenu(menuType);
			
			System.out.println("Choose file type to proceed e.g 1 or 2");
			System.out.println(" 1. Filter only UEFA confederate countries from file");
			System.out.println(" 2. Filter only CAF confederate countries from file");
			System.out.println(" 3. Filter only CONCACAF confederate countries from file");
			
			System.out.println(" 6. Back to Main Menu");
			
			int chooserMenus = scanner.nextInt();
			
			if(6==chooserMenus) {
				ifClose = true;
			}else if(1==chooserMenus || 2==chooserMenus || 3==chooserMenus) {
				
				try {
					File file = new File("/Users/anmolk/Desktop/Project2Fall/Project2Fall/src/Default/Data Files/fifaCountries.txt");
					//File file = new File("Data Files\\fifaCountries.txt");
					
					
					Scanner scan = new Scanner(file);
					
					
					scan.useDelimiter(",|\\n");
					
					String column1 = scan.next();
					String column2 = scan.next();
					String column3 = scan.next();
					String column4 = scan.next();
					String column5 = scan.next();
					
					System.out.printf("%-20s %15s %17s %18s %20s\n",column1,column2,column3,column4,column5);
					
					while(scan.hasNext()) {
						
						String country = scan.next();
						String confederation = scan.next();
						String population_share = scan.next();
						String tv_audience_share = scan.next();
						String gdp_weighted_share = scan.next();
						
						Country countryClass = new Country(country,confederation,population_share,tv_audience_share,gdp_weighted_share);
						
						//put values to country class
						if(3==chooserMenus) {
							//concacaf
							if("CONCACAF".contentEquals(confederation)) {
								myMapTree.put(country,countryClass);
							}
							
							
						}else if(2==chooserMenus) {
							//caf
							if("CAF".contentEquals(confederation)) {
								myMapTree.put(country,countryClass);
							}
							
							
						}else {
							//uefa
							if("UEFA".contentEquals(confederation)) {
								myMapTree.put(country,countryClass);
							}
						
							
						}
						
						
					}
					
					
					for(String key:myMapTree.keySet()) {
						
						Country country1 = myMapTree.get(key);
						
						System.out.printf("%-20s %15s %17s %18s %20s\n",
								country1.country,
								country1.confederation,
								country1.population_share,
								country1.tv_audience_share,
								country1.gdp_weighted_share);
								
						
					}
					
					//create file for sorted file incase not presented
					createFileCommand(myMapTree,chooserMenus);
					
					myMapTree.clear();
					scan.close();
					System.out.println("\n ######## END OF FILE ######## \n");
					
					
					
				}catch(Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
				
				
			}else {
				System.out.println("Invalid choice! Try again");
			}
			
			
		}
		
		
		
	}
	
	/*
	 * Does the creation of files immediately 
	 * */
	public static void createFileCommand(TreeMap<String,Country> myMaps,int choose) {
		
		File fileOutUEFA = new File("/Users/anmolk/Desktop/Project2Fall/Project2Fall/src/Default/Filter Files/EUFACountries.txt");
		File fileOutCAF = new File("/Users/anmolk/Desktop/Project2Fall/Project2Fall/src/Default/Filter Files/CFACountries.txt");
		File fileOutCONCACAF = new File("/Users/anmolk/Desktop/Project2Fall/Project2Fall/src/Default/Filter Files/CONCACAFCountries.txt");
		
		boolean isWrite = false;
		PrintWriter printwriter = null;
		
		try {
			
			
			if(3==choose) {
				
				if(!fileOutCONCACAF.exists()) {
					isWrite = fileOutCONCACAF.createNewFile();
				}
				
				if(isWrite) {
					
					printwriter = new PrintWriter(fileOutCONCACAF);
					
					for(String key:myMaps.keySet()) {
						
						Country country1 = myMaps.get(key);
						
						printwriter.printf("%s,%s,%s,%s,%s \n",
								country1.country,
								country1.confederation,
								country1.population_share,
								country1.tv_audience_share,
								country1.gdp_weighted_share);
								
						
					}
					printwriter.flush();
					printwriter.close();
				}
				
			}else if(2==choose) {
				
				if(!fileOutCAF.exists()) {
					isWrite = fileOutCAF.createNewFile();
				}
				
				if(isWrite) {
					printwriter = new PrintWriter(fileOutCAF);
					
					
					for(String key:myMaps.keySet()) {
						
						Country country1 = myMaps.get(key);
						
						printwriter.printf("%s,%s,%s,%s,%s \n",
								country1.country,
								country1.confederation,
								country1.population_share,
								country1.tv_audience_share,
								country1.gdp_weighted_share);
								
						
					}
					
					printwriter.flush();
					printwriter.close();
				}
				
			}else {
				//uefa
				
				if(!fileOutUEFA.exists()) {
					isWrite = fileOutUEFA.createNewFile();
				
				}
				
				if(isWrite) {
					printwriter = new PrintWriter(fileOutUEFA);
					
					
					for(String key:myMaps.keySet()) {
						
						Country country1 = myMaps.get(key);
						
						printwriter.printf("%s,%s,%s,%s,%s \n",
								country1.country,
								country1.confederation,
								country1.population_share,
								country1.tv_audience_share,
								country1.gdp_weighted_share);
								
						
					}
					
					printwriter.flush();
					printwriter.close();
					
					
				}
				
			}
			
			myMaps.clear();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
		
		
		
		
		
	}
	
	/*
	 * Does the actual sorting with regard to choose 
	 * */
	public static void intiateMergeMenuChoose(String menuType) {
		
		boolean ifCloseOne = false;
		boolean isOutFilePresent = false;
		
		TreeMap<String,Country> myCountryMap = new TreeMap<>();
		TreeMap<String,TreeMap<String,Country>> allMaps = new TreeMap<>();
		
		try {
			
			
			File outFile = new File("/Users/anmolk/Desktop/Project2Fall/Project2Fall/src/Default/Merge Files/fifaMergedCountries.txt");
			File file = new File("/Users/anmolk/Desktop/Project2Fall/Project2Fall/src/Default/Data Files/fifaCountries.txt");
			
			if(outFile.exists()) {
				isOutFilePresent = false;
				System.out.println("The Merged file is present");
			}else {
				isOutFilePresent = outFile.createNewFile();
			}
			
			
			while((isOutFilePresent) && (!ifCloseOne)) {
				
				setupAnyMenu(menuType);
				
				System.out.println();
				System.out.println("Display Segmented Confederate data of countries with sorted criteria of your choice");
				System.out.println("Choose one of the criterias below.(A file with the data will be created automatically)");
				System.out.println(" 1. Sorted Population Share");
				System.out.println(" 2. Sorted TV Audience Share");
				System.out.println(" 3. Sorted GDP Weighted Share");
				
				
				System.out.println(" 7. Back to Main Menu");
				
				int chooserMenus = scanner.nextInt();
				
				if(7==chooserMenus) {
					ifCloseOne = true;
					
				}else if(1==chooserMenus || 2==chooserMenus || 3==chooserMenus) {
					
					//allMaps = getAllMapsFromFile(file);
					
					Scanner scan = new Scanner(file);
					
					
					scan.useDelimiter(",|\\n");
					
					String column1 = scan.next();
					String column2 = scan.next();
					String column3 = scan.next();
					String column4 = scan.next();
					String column5 = scan.next();
					
					System.out.printf("%-20s %15s %17s %18s %20s\n",column1,column2,column3,column4,column5);
					
					while(scan.hasNext()) {
						
						String country = scan.next();
						String confederation = scan.next();
						String population_share = scan.next();
						String tv_audience_share = scan.next();
						String gdp_weighted_share = scan.next();
						
						Country countryClass = new Country(country,confederation,population_share,tv_audience_share,gdp_weighted_share);
						
						allMaps.put(confederation,myCountryMap);
						
						//put values to country class
						if(3==chooserMenus) {
							//Sorted GDP Weighted Share
							if(allMaps.containsKey(confederation) && (null==allMaps.get(confederation))) {
								
								allMaps.put(confederation, new TreeMap<String,Country>());
							}
							
							
							allMaps.get(confederation).put(gdp_weighted_share, countryClass);
						}else if(2==chooserMenus) {
							//Sorted TV Audience Share
							if(allMaps.containsKey(confederation) && (null==allMaps.get(confederation))) {
								
								allMaps.put(confederation, new TreeMap<String,Country>());
							}
							
							
							allMaps.get(confederation).put(tv_audience_share, countryClass);
						}else {
							//Sorted Population Share
							
							if(allMaps.containsKey(confederation) && (null==allMaps.get(confederation))) {
								
								allMaps.put(confederation, new TreeMap<String,Country>());
							}
							
							
							allMaps.get(confederation).put(population_share, countryClass);
							
							
						}
						
						
					}
					
					scan.close();
					
					PrintWriter writer = new PrintWriter(outFile);
					
					
					for(String key:allMaps.keySet()) {
						if(isOutFilePresent) {writer.printf("%s\n,", key);}
						TreeMap<String, Country> theCountryMap = allMaps.get(key);
						for(String key2:theCountryMap.keySet()) {
							Country country1 = theCountryMap.get(key2);
							
							System.out.printf("%-20s %15s %17s %18s %20s\n",
									country1.country,
									country1.confederation,
									country1.population_share,
									country1.tv_audience_share,
									country1.gdp_weighted_share);
							
							if(isOutFilePresent) {
								writer.printf("%s , %s, %s, %s,%s \n", country1.country,
										country1.confederation,
										country1.population_share,
										country1.tv_audience_share,
										country1.gdp_weighted_share);
							}
							
							
						}
						
						theCountryMap.clear();
						
					}
					
					writer.close();
					allMaps.clear();
					
					System.out.println("\n ######## END OF FILE ######## \n");
					
				}else {
					
					System.out.println("Invalid choice! Try again");
				}
				
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	
	public static class Country{
		
		private String country;
		private String confederation;
		private String population_share;
		private String tv_audience_share;
		private String gdp_weighted_share;
		
		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getConfederation() {
			return confederation;
		}

		public void setConfederation(String confederation) {
			this.confederation = confederation;
		}

		public String getPopulation_share() {
			return population_share;
		}

		public void setPopulation_share(String population_share) {
			this.population_share = population_share;
		}

		public String getTv_audience_share() {
			return tv_audience_share;
		}

		public void setTv_audience_share(String tv_audience_share) {
			this.tv_audience_share = tv_audience_share;
		}

		public String getGdp_weighted_share() {
			return gdp_weighted_share;
		}

		public void setGdp_weighted_share(String gdp_weighted_share) {
			this.gdp_weighted_share = gdp_weighted_share;
		}

		public Country(String country, String confederation, String population_share, String tv_audience_share,
				String gdp_weighted_share) {
			//super();
			this.country = country;
			this.confederation = confederation;
			this.population_share = population_share;
			this.tv_audience_share = tv_audience_share;
			this.gdp_weighted_share = gdp_weighted_share;
		}
		
		
		
		
		
	}
}
